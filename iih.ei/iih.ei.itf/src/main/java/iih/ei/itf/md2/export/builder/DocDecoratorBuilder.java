package iih.ei.itf.md2.export.builder;

import iih.ei.itf.md2.export.Decorator;

public class DocDecoratorBuilder implements DecoratorBuilder{

	public Decorator build() {
		throw new RuntimeException("暂未支持word doc文档的导出");
	}

}
