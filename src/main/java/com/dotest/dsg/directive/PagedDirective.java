//package com.dotest.dsg.directive;
//
//import com.blazebit.persistence.CriteriaBuilder;
//import com.blazebit.persistence.PagedList;
//import com.netflix.graphql.dgs.DgsDirective;
//import graphql.Scalars;
//import graphql.schema.*;
//import graphql.schema.idl.SchemaDirectiveWiring;
//import graphql.schema.idl.SchemaDirectiveWiringEnvironment;
//
//import java.util.Map;
//
//@DgsDirective(name = "paged")
//public class PagedDirective implements SchemaDirectiveWiring {
//
//    @Override
//    public GraphQLFieldDefinition onField(GraphQLFieldDefinition field, SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
//        // 1. 获取原始的返回类型 (例如 Book)
//        GraphQLUnmodifiedType rawType = (GraphQLUnmodifiedType) ((GraphQLList) field.getType()).getWrappedType();
//        String typeName = ((GraphQLNamedType) rawType).getName();
//        String paginationTypeName = typeName + "PagedResult";
//
//        // 2. 动态创建一个新的 ObjectType (XxxPagedResult)
//        // 这一步解决了“不手动在 Schema 定义”的问题
//        GraphQLObjectType pagedResultType = GraphQLObjectType.newObject()
//                .name(paginationTypeName)
//                .field(f -> f.name("content").type(new GraphQLList(rawType)))
//                .field(f -> f.name("totalElements").type(Scalars.GraphQLInt))
//                .field(f -> f.name("totalPages").type(Scalars.GraphQLInt))
//                .field(f -> f.name("pageNumber").type(Scalars.GraphQLInt))
//                .build();
//
//        // 将字段的返回类型从 [Book] 改为 BookPagedResult
//        env.getCodeRegistry().dataFetcher((GraphQLObjectType) env.getFieldsContainer(), field, createDataFetcher(env));
//
//        // 返回修改了类型后的字段
//        return field.transform(builder -> builder.type(pagedResultType));
//    }
//
//    private DataFetcher<?> createDataFetcher(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> env) {
//        DataFetcher<?> originalFetcher = env.getCodeRegistry().getDataFetcher((GraphQLObjectType) env.getFieldsContainer(), env.getFieldDefinition());
//
//        return fetchingEnvironment -> {
//            // 执行原始 DataFetcher，预期它返回的是 Blaze-Persistence 的 CriteriaBuilder 或 PagedList
//            Object result = originalFetcher.get(fetchingEnvironment);
//
//            int page = fetchingEnvironment.getArgument("page");
//            int size = fetchingEnvironment.getArgument("size");
//
//            // 如果返回的是 CriteriaBuilder (推荐，实现延迟加载)
//            if (result instanceof CriteriaBuilder) {
//                // 这里假设你已经集成了 Blaze-Persistence 的 EntityViewManager
//                // 具体的 PagedList 获取逻辑可以封装在 Service 中
//                PagedList<?> pagedList = ((CriteriaBuilder<?>) result)
//                        .page(page * size, size)
//                        .getResultList();
//
//                return Map.of(
//                        "content", pagedList,
//                        "totalElements", pagedList.getTotalSize(),
//                        "totalPages", pagedList.getTotalPages(),
//                        "pageNumber", page
//                );
//            }
//
//            // 如果已经是 PagedList
//            if (result instanceof PagedList) {
//                PagedList<?> pagedList = (PagedList<?>) result;
//                return Map.of("content", pagedList, "totalElements", pagedList.getTotalSize());
//            }
//
//            return result;
//        };
//    }
//}
