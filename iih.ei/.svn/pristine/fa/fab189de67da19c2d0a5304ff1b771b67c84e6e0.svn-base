package iih.ei.itf.md2.export;

import iih.ei.itf.md2.export.builder.DecoratorBuilder;

/**
 * 文档装饰器的工厂，使用反射来生成相应装饰器。使用反射的原因是为了降低MD2File的包耦合度
 * 
 * @author hao_wu
 * @time 2015年5月15日 下午10:00:39
 */
public class BuilderFactory {
	private static final int PDF_ITEXT_5X = 5;
	private static final int PDF_ITEXT_4X = 4;

	private static int itextVersion = PDF_ITEXT_4X;

	/**
	 * 检查iText的版本
	 */
	static {
		String doc5x = "com.itextpdf.text.Document";
//		String doc4x = "com.lowagie.text.Document";
		try {
			Class.forName(doc5x);
			itextVersion = PDF_ITEXT_5X;
		} catch (ClassNotFoundException e) {
			itextVersion = PDF_ITEXT_4X;
		}
	}

	private static DecoratorBuilder initDecoratorBuilder(String className) {
		try {
			@SuppressWarnings("rawtypes")
			Class clazz = Class.forName(className);
			return (DecoratorBuilder) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static final String DOC_BUILDER_CLASS_NAME = "iih.ei.itf.md2.export.builder.DocDecoratorBuilder";
	private static final String DOCX_BUILDER_CLASS_NAME = "iih.ei.itf.md2.export.builder.DocxDecoratorBuilder";
	private static final String PDF_4X_BUILDER_CLASS_NAME = "iih.ei.itf.md2.export.builder.PDFDecoratorBuilder4x";
	private static final String PDF_5X_BUILDER_CLASS_NAME = "iih.ei.itf.md2.export.builder.PDFDecoratorBuilder5x";
	private static final String HTML_BUILDER_CLASS_NAME = "iih.ei.itf.md2.export.builder.HTMLDecoratorBuilder";

	public static Decorator build(String ext) {
		if (ext.equalsIgnoreCase("docx")) {
			return build(FileExName.DOCX);
		} else if (ext.equalsIgnoreCase("doc")) {
			return build(FileExName.DOC);
		} else if (ext.equalsIgnoreCase("pdf")) {
			return build(FileExName.PDF);
		} else if (ext.equalsIgnoreCase("html")) {
			return build(FileExName.HTML);
		} else if (ext.equalsIgnoreCase("htm")) {
			return build(FileExName.HTM);
		} else {
			throw new RuntimeException("请确认输出的文档为docx，doc，pdf，html的文档格式");
		}
	}

	public static Decorator build(FileExName exName) {
		DecoratorBuilder decoratorBuilder;
		if (FileExName.DOCX.equals(exName)) {
			decoratorBuilder = initDecoratorBuilder(DOCX_BUILDER_CLASS_NAME);
		} else if (FileExName.DOC.equals(exName)) {
			decoratorBuilder = initDecoratorBuilder(DOC_BUILDER_CLASS_NAME);
		} else if (FileExName.PDF.equals(exName)) {
			if (itextVersion == PDF_ITEXT_5X) {
				decoratorBuilder = initDecoratorBuilder(PDF_5X_BUILDER_CLASS_NAME);
			} else {
				decoratorBuilder = initDecoratorBuilder(PDF_4X_BUILDER_CLASS_NAME);
			}
		} else if (FileExName.HTML.equals(exName) || FileExName.HTM.equals(exName)) {
			decoratorBuilder = initDecoratorBuilder(HTML_BUILDER_CLASS_NAME);
		} else {
			throw new RuntimeException("请确认输出的文档为docx，doc，pdf，html的文档格式");
		}
		Decorator decorator = decoratorBuilder.build();
		return decorator;
	}

}
