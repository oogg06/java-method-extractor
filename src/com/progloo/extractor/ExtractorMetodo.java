package com.progloo.extractor;

import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ExtractorMetodo {
	
	public static void main(String[] args) throws ParseException, IOException {
		/*String archivo="/media/usuario/OSCAR/recuperar2/ws2/Damas/src/com/progloo/damas/Tablero.java";
		String metodo="getContenido";*/
		String archivo=args[0];
		String metodo=args[1];
		FileInputStream fis=new FileInputStream(archivo);
		try {
			CompilationUnit cu=JavaParser.parse(fis);
			// visit and print the methods names
	        
	        new MetodosVisitor().visit(cu,metodo); 
		} finally {
			fis.close();
		}
	}
	private static class MetodosVisitor  extends VoidVisitorAdapter{
		 @Override
		 public void visit(MethodDeclaration n, Object arg) {
			 String nombre=n.getName();
			 if (nombre.equals(arg)){
				 System.out.println(n.getDeclarationAsString());
				 System.out.println(n.getBody());
			 }
		 }
	}
} //Fin de la clase

