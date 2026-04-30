package com.dotest.dsg.directive;

import com.netflix.graphql.dgs.DgsDirective;
import graphql.schema.*;
import graphql.schema.idl.SchemaDirectiveWiring;
import graphql.schema.idl.SchemaDirectiveWiringEnvironment;

@DgsDirective(name = "uppercase")
public class UppercaseDirective implements SchemaDirectiveWiring {
    @Override
    public GraphQLFieldDefinition onField(SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition> environment) {
        GraphQLFieldsContainer fieldsContainer = environment.getFieldsContainer();
        GraphQLFieldDefinition fieldDefinition = environment.getFieldDefinition();

        DataFetcher<?> originalDataFetcher = environment.getCodeRegistry()
                .getDataFetcher((GraphQLObjectType) fieldsContainer, fieldDefinition);
        DataFetcher<?> dataFetcher = DataFetcherFactories.wrapDataFetcher(
                originalDataFetcher,
                (dataFetchingEnvironment, value) -> {
                    if (value instanceof String) {
                        return ((String) value).toUpperCase();
                    }
                    return value;
                }
        );
        environment.getCodeRegistry().dataFetcher((GraphQLObjectType) fieldsContainer, fieldDefinition, dataFetcher);
        return fieldDefinition;
    }
}
