package com.dotest.dsg.utils;

public class SnowflakeIdGenerator {

    // 起始时间戳
    private static final long START_TIMESTAMP = 1704067200000L;

    // 每部分占用位数
    private static final long SEQUENCE_BIT = 12;
    private static final long MACHINE_BIT = 5;
    private static final long DATACENTER_BIT = 5;

    // 最大值
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    // 偏移量
    private static final long MACHINE_LEFT = SEQUENCE_BIT;
    private static final long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private static final long TIMESTAMP_LEFT =
            DATACENTER_LEFT + DATACENTER_BIT;

    // 配置
    private static final long DATACENTER_ID = 1;
    private static final long MACHINE_ID = 1;

    private static long sequence = 0L;
    private static long lastTimestamp = -1L;

    public static synchronized long nextId() {

        long timestamp = System.currentTimeMillis();

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;

            if (sequence == 0L) {
                while (timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - START_TIMESTAMP) << TIMESTAMP_LEFT)
                | (DATACENTER_ID << DATACENTER_LEFT)
                | (MACHINE_ID << MACHINE_LEFT)
                | sequence;
    }
}