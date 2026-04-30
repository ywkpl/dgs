package com.dotest.dsg.codegen.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import graphql.language.VariableDefinition;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DoItGraphQLQuery extends GraphQLQuery {
  public DoItGraphQLQuery(Integer page, Integer size, String queryName, Set<String> fieldsSet) {
    super("query", queryName);
    if (page != null || fieldsSet.contains("page")) {
        getInput().put("page", page);
    }if (size != null || fieldsSet.contains("size")) {
        getInput().put("size", size);
    }
  }

  public DoItGraphQLQuery(Integer page, Integer size, String queryName, Set<String> fieldsSet,
      Map<String, String> variableReferences, List<VariableDefinition> variableDefinitions) {
    super("query", queryName);
    if (page != null || fieldsSet.contains("page")) {
        getInput().put("page", page);
    }if (size != null || fieldsSet.contains("size")) {
        getInput().put("size", size);
    }
    if(variableDefinitions != null) {
       getVariableDefinitions().addAll(variableDefinitions);
    }

    if(variableReferences != null) {
       getVariableReferences().putAll(variableReferences);
    }                      
  }

  public DoItGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
    return "doIt";
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private Set<String> fieldsSet = new HashSet<>();

    private final Map<String, String> variableReferences = new HashMap<>();

    private final List<VariableDefinition> variableDefinitions = new ArrayList<>();

    private Integer page;

    private Integer size;

    private String queryName;

    public DoItGraphQLQuery build() {
      return new DoItGraphQLQuery(page, size, queryName, fieldsSet, variableReferences, variableDefinitions);
               
    }

    public Builder page(Integer page) {
      this.page = page;
      this.fieldsSet.add("page");
      return this;
    }

    public Builder pageReference(String variableRef) {
      this.variableReferences.put("page", variableRef);
      this.variableDefinitions.add(graphql.language.VariableDefinition.newVariableDefinition(variableRef, new graphql.language.TypeName("Int")).build());
      this.fieldsSet.add("page");
      return this;
    }

    public Builder size(Integer size) {
      this.size = size;
      this.fieldsSet.add("size");
      return this;
    }

    public Builder sizeReference(String variableRef) {
      this.variableReferences.put("size", variableRef);
      this.variableDefinitions.add(graphql.language.VariableDefinition.newVariableDefinition(variableRef, new graphql.language.TypeName("Int")).build());
      this.fieldsSet.add("size");
      return this;
    }

    public Builder queryName(String queryName) {
      this.queryName = queryName;
      return this;
    }
  }
}
