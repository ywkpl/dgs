package com.dotest.dsg.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import graphql.language.VariableDefinition;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShowsGraphQLQuery extends GraphQLQuery {
  public ShowsGraphQLQuery(String titleFilter, String queryName, Set<String> fieldsSet) {
    super("query", queryName);
    if (titleFilter != null || fieldsSet.contains("titleFilter")) {
        getInput().put("titleFilter", titleFilter);
    }
  }

  public ShowsGraphQLQuery(String titleFilter, String queryName, Set<String> fieldsSet,
      Map<String, String> variableReferences, List<VariableDefinition> variableDefinitions) {
    super("query", queryName);
    if (titleFilter != null || fieldsSet.contains("titleFilter")) {
        getInput().put("titleFilter", titleFilter);
    }
    if(variableDefinitions != null) {
       getVariableDefinitions().addAll(variableDefinitions);
    }

    if(variableReferences != null) {
       getVariableReferences().putAll(variableReferences);
    }                      
  }

  public ShowsGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
    return "shows";
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private final Map<String, String> variableReferences = new HashMap<>();

    private final List<VariableDefinition> variableDefinitions = new ArrayList<>();

    private String titleFilter;

    private String queryName;

    public ShowsGraphQLQuery build() {
      return new ShowsGraphQLQuery(titleFilter, queryName, fieldsSet, variableReferences, variableDefinitions);
               
    }

    public Builder titleFilter(String titleFilter) {
      this.titleFilter = titleFilter;
      this.fieldsSet.add("titleFilter");
      return this;
    }

    public Builder titleFilterReference(String variableRef) {
      this.variableReferences.put("titleFilter", variableRef);
      this.variableDefinitions.add(graphql.language.VariableDefinition.newVariableDefinition(variableRef, new graphql.language.TypeName("String")).build());
      this.fieldsSet.add("titleFilter");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
