package iih.ci.mrqc.autoqc.rulemethod;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class MrXmlAnalysisUtil {

	public static Document parse(byte[] bs) {
		try {
			SAXReader reader = new SAXReader();
			reader.setEncoding("GB2312");
			Document document = reader.read(new ByteArrayInputStream(bs));
			return document;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean isZHUSU(Document doc,String xmlvalue) {
		boolean b = treeWalk(doc.getRootElement(),xmlvalue);
		return b;
	}

	public static boolean isZHUSU(byte[] bs,String xmlvalue) {
		Document doc = parse(bs);
		boolean b = isZHUSU(doc,xmlvalue);
		return b;
	}

	public static Document parse(File bs) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(bs);
		return document;
	}

	public static Boolean treeWalk(Element element,String xmlvalue) {
		boolean b = false;
		for (int i = 0, size = element.nodeCount(); i < size; i++) {
			Node node = element.node(i);
			if (node instanceof Element) {
				// System.out.println(node.getName());
				if (node.getName().equals("Element")) {

					boolean isit = isItZHUSU((Element) node,xmlvalue);

					if (isit) {
						List<Node> selectNodes = node
								.selectNodes("./XElements/Element/InnerValue");
						if (selectNodes.size() <= 0)
							return false;
						String text = selectNodes.get(0)
								.getText();
						if ("".equals(text)) {
							b = false;
						} else {
							return isit;
						}
					}
				}

				b = treeWalk((Element) node,xmlvalue);
				if (b)
					return b;
			} else {
				// do something....
				// System.out.println();
			}
		}
		return b;
	}

	private static boolean isItZHUSU(Element node,String xmlvalue) {
		List<Node> selectNodes = node.selectNodes("./Attributes/Attribute");
		if (selectNodes.size() == 0)
			return false;
		else {
			for (Node n : selectNodes) {
				List<Node> selectSonNodes = n.selectNodes("./Name");
				String name = selectSonNodes.get(0).getText();
				List<Node> selectSonNodes1 = n.selectNodes("./Value");
				if(selectSonNodes1.size()<=0) return false;
				String value = selectSonNodes1.get(0).getText();
				if (name.equals("gpcode") && value.equals(xmlvalue)) {
					return true;
				}
//				if (name.equals("decode") && value.equals("F.DE04.01.119.00")) {
//					return true;
//				}
			}
		}
		return false;
	}
}
