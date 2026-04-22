// Generated from myparser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link myparserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface myparserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link myparserParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(myparserParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(myparserParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(myparserParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(myparserParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(myparserParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(myparserParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(myparserParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(myparserParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(myparserParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(myparserParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(myparserParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(myparserParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(myparserParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(myparserParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(myparserParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(myparserParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(myparserParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(myparserParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#funcCallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallStmt(myparserParser.FuncCallStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(myparserParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#printfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintfStmt(myparserParser.PrintfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#scanfStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScanfStmt(myparserParser.ScanfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(myparserParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#andExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(myparserParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#eqExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(myparserParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#relExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelExpr(myparserParser.RelExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#addExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(myparserParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#mulExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExpr(myparserParser.MulExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(myparserParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link myparserParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(myparserParser.PrimaryExprContext ctx);
}