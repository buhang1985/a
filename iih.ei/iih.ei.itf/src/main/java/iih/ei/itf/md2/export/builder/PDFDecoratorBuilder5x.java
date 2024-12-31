package iih.ei.itf.md2.export.builder;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;

import iih.ei.itf.md2.export.Decorator;
import iih.ei.itf.md2.export.PDFDecorator5x;

public class PDFDecoratorBuilder5x implements DecoratorBuilder {

	public Decorator build() {
		return new PDFDecorator5x(new Document(PageSize.A4, 75F, 76F, 53F, 53F));
	}

}
