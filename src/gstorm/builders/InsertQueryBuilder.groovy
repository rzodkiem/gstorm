package gstorm.builders

import gstorm.metadata.ClassMetaData

class InsertQueryBuilder extends QueryBuilderSupport{

    InsertQueryBuilder(ClassMetaData classMetaData) {
        super(classMetaData)
    }

    String build() {
        final fieldNames = classMetaData.fields*.name
        final columns = fieldNames.join ", "
        final placeholders = fieldNames.collect { "?" }.join(", ")

        "INSERT INTO ${classMetaData.tableName} (${columns}) values (${placeholders})".toString()
    }
}