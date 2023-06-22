package com.tencent;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class ParserDriver {
    public static void main(String[] args) {
        String query = "SELECT col FROM TBL";
        SqlBaseLexer lexer = new SqlBaseLexer(new ANTLRInputStream(query.toUpperCase()));
        SqlBaseParser parser = new SqlBaseParser(new CommonTokenStream(lexer));
        MyVisitor visitor = new MyVisitor();
        SqlBaseParser.SingleStatementContext root = parser.singleStatement();
        root.accept(visitor);
    }
}
