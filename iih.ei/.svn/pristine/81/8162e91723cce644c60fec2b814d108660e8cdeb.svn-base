package iih.ei.itf.md2.export;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import iih.ei.itf.md2.markdown.Block;
import iih.ei.itf.md2.markdown.BlockType;
import iih.ei.itf.md2.markdown.ValuePart;
import iih.ei.itf.md2.util.ImgHelper;
import iih.ei.itf.md2.util.MD2FileUtil;

public class PDFDecorator5x implements Decorator {
	private Document doc;
	private static BaseFont bfChinese;

	private PdfWriter _writer;

	static {
		try {
			bfChinese = BaseFont.createFont("MSYH.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		} catch (Exception e1) {
			try {
				bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			} catch (Exception e2) {
			}
			System.out.println("没有找到MSYH.TTF字体文件，使用itext自带中文字体。如果需要更好的显示效果，可以添加MSYH.TTF到src目录下");
		}
	}
	Font fontYHNormal = new Font(bfChinese, 12, Font.NORMAL);

	public PDFDecorator5x(Document doc) {
		this.doc = doc;
	}

	public void beginWork(String outputFilePath) {
		try {
			_writer = PdfWriter.getInstance(doc, new FileOutputStream(outputFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.open();
	}

	public void beginWork(OutputStream outputStream) {
		try {
			_writer = PdfWriter.getInstance(doc, outputStream);
			this._writer.setViewerPreferences(PdfWriter.PageModeUseOutlines);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		doc.open();
	}

	public void decorate(List<Block> list) {
		for (Block block : list) {
			try {
				switch (block.getType()) {
				case CODE:
					doc.add(codeParagraph(block.getValueParts()));
					break;
				case HEADLINE:
					doc.add(headerParagraph(block.getValueParts(), block.getLevel()));
					break;
				case QUOTE:
					List<Element> quotes = quoteParagraph(block.getListData());
					for (Element element : quotes) {
						doc.add(element);
					}
					break;
				case TABLE:
					doc.add(tableParagraph(block.getTableData()));
					break;
				case ORDERED_LIST:
					List<Element> els = listParagraph(block.getListData(), true);
					for (Element element : els) {
						doc.add(element);
					}
					break;
				case UNORDERED_LIST:
					els = listParagraph(block.getListData(), false);
					for (Element element : els) {
						doc.add(element);
					}
					break;
				default:
					doc.add(commonTextParagraph(block.getValueParts()));
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void afterWork(String outputFilePath) {
		doc.close();
	}

	private List<Element> listParagraph(List<Block> listData, boolean isOrder) {
		List<Element> list = new ArrayList<Element>();
		int j = 1;
		for (Block block : listData) {
			ValuePart[] vps = block.getValueParts();
			ValuePart[] newVps = new ValuePart[vps.length + 1];
			if (isOrder) {
				newVps[0] = new ValuePart(j + ". ");
			} else {
				newVps[0] = new ValuePart("• ");
			}
			for (int i = 1; i < newVps.length; i++) {
				newVps[i] = vps[i - 1];
			}
			list.add(commonTextParagraph(newVps));
			j++;
		}
		return list;
	}

	private Element headerParagraph(ValuePart[] valueParts, int level) {

		PdfPTable pdfPTable = new PdfPTable(1);
		pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
		pdfPTable.setSpacingAfter(0);
		pdfPTable.setSpacingBefore(0);
		pdfPTable.setWidthPercentage(100);

		for (ValuePart valuePart : valueParts) {

			BlockType[] types = valuePart.getTypes();
			float size = getHenderFontSize(level);
			// 修正字体大小 hao_wu 2019-10-11
			Font font = new Font(bfChinese, size, Font.BOLD);
//			Font font = new Font(bfChinese, 30 - 4 * level, Font.BOLD);
			if (types != null) {
				for (BlockType type : types) {
					formatByType(font, type, valuePart.getLevel());
				}
			}
			Chunk chunk = new Chunk(valuePart.getValue(), font);

			Paragraph paragraph = new Paragraph();
//			int[] spacs = getHeaderSpacing(level);
//			paragraph.setSpacingBefore(spacs[0]);
//			paragraph.setSpacingAfter(spacs[1]);
			paragraph.add(chunk);

			PdfPCell cell = new PdfPCell();
			if (level <= 1) {
				cell.setBorder(1);
				cell.setBorderWidthBottom(1);
				cell.setBorderWidthTop(0);
				cell.setBorderColor(new BaseColor(238, 238, 238));
			} else {
				cell.setBorder(0);
			}

			float[] spacs = getHeaderSpacing(level);
			cell.setPaddingTop(spacs[0]);
			cell.setPaddingBottom(spacs[1]);
			cell.addElement(paragraph);
			pdfPTable.addCell(cell);
		}
		return pdfPTable;
//		Paragraph paragraph = new Paragraph();
//		for (ValuePart valuePart : valueParts) {
//			BlockType[] types = valuePart.getTypes();
//			float size = getHenderFontSize(level);
//			// 修正字体大小 hao_wu 2019-10-11
//			Font font = new Font(bfChinese, size, Font.BOLD);
////			Font font = new Font(bfChinese, 30 - 4 * level, Font.BOLD);
//			if (types != null) {
//				for (BlockType type : types) {
//					formatByType(font, type, valuePart.getLevel());
//				}
//			}
//			Chunk chunk = new Chunk(valuePart.getValue(), font);
//			
//			PdfPTable pdfPTable = new PdfPTable(1);
//			pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
//			pdfPTable.setSpacingAfter(0);
//			PdfPCell cell = new PdfPCell();
//			cell.setBorder(1);
//			cell.setBorderWidthBottom(0);
//			cell.setBorderWidthTop(1);
//			cell.setBorderColor(new BaseColor(238,238,238));
//			pdfPTable.addCell(cell);
//			
//			paragraph.add(chunk);
//			paragraph.add(pdfPTable);
//		}
//		int[] spacs=getHeaderSpacing(level);
//		paragraph.setSpacingBefore(spacs[0]);
//		paragraph.setSpacingAfter(spacs[1]);
////		paragraph.setSpacingBefore(20);
////		paragraph.setSpacingAfter(10);
//		return paragraph;
	}

	private float[] getHeaderSpacing(int level) {
//		return new int[] { 0, 0 };
		if (level == 0) {
			return new float[] { 14.8F, 13F };
		} else if (level == 1) {
			return new float[] { 10F, 10F };
		} else if (level == 2) {
			return new float[] { 10F, 7F };
		} else if (level == 3) {
			return new float[] { 10F, 7F };
		} else {
			return new float[] { 34F, 33F };
		}
	}

	/**
	 * 根据标题等级返回标题大小
	 * 
	 * @author hao_wu 2019-10-11
	 * @param level 标题等级
	 * @return
	 */
	private float getHenderFontSize(int level) {
		if (level == 0) {
			return 21.5F;
		} else if (level == 1) {
			return 16F;
		} else if (level == 2) {
			return 14F;
		} else if (level == 3) {
			return 10F;
		} else {
			return 24F;
		}
	}

	private Element tableParagraph(List<List<String>> tableData) {

		int nRows = tableData.size();
		int nCols = 0;
		for (List<String> list : tableData) {
			int s = list.size();
			if (nCols < s) {
				nCols = s;
			}
		}

		PdfPTable pdfPTable = new PdfPTable(nCols);
		pdfPTable.setWidthPercentage(100);

		float[] columnWidth = new float[nCols];

		Font titleFont = new Font(bfChinese, 9.5F, Font.BOLD);
		Font font = new Font(bfChinese, 9.5F);
		for (int i = 0; i < nRows; i++) {
			List<String> colDatas = tableData.get(i);
			Font rowFont = i == 0 ? titleFont : font;
			for (int j = 0; j < nCols; j++) {
				PdfPCell cell = new PdfPCell();
				if (i % 2 == 0) {
					cell.setBackgroundColor(new BaseColor(248, 248, 248));
				}
				cell.setBorderColor(new BaseColor(223, 226, 229));
				cell.setPaddingBottom(8.6F);
				cell.setPaddingLeft(7.4F);
				cell.setPaddingRight(4.9F);
				Chunk textChunk = null;
				try {
					textChunk = new Chunk(colDatas.get(j), rowFont);
					cell.addElement(textChunk);
				} catch (Exception e) {
					textChunk = new Chunk("", rowFont);
					cell.addElement(textChunk);
				}
				if (textChunk.getWidthPoint() + cell.getPaddingLeft() + cell.getPaddingRight() > columnWidth[j]) {
					columnWidth[j] = textChunk.getWidthPoint() + cell.getPaddingLeft() + cell.getPaddingRight();
				}
				pdfPTable.addCell(cell);
			}
		}

		// 列宽比例
		try {
			pdfPTable.setWidths(columnWidth);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
		pdfPTable.setSpacingBefore(6.5F);
		pdfPTable.setSpacingAfter(6.5F);
		return pdfPTable;
	}

	private Element imgParagraph(ValuePart valuePart) {
		final String imgFile = valuePart.getValue();
		final PdfPTable pdfPTable = new PdfPTable(1);
		final PdfPCell cell = new PdfPCell();
		ImgHelper helper = new ImgHelper() {

			@Override
			public void setIntoFile(InputStream is) {

				if (is == null) {
					return;
				}
				ByteArrayOutputStream baos;
				try {
					baos = MD2FileUtil.inputStream2ByteArrayOutputStream(is);
					byte[] bs = baos.toByteArray();
					Image image = Image.getInstance(bs);
					InputStream tmpIs = new ByteArrayInputStream(baos.toByteArray());
					int[] wh = getImgWidthHeight(tmpIs);
					int p = wh[0] * 100 / 1000;
					p = p > 100 ? 100 : p;
					pdfPTable.setWidthPercentage(p);
					cell.setBorder(PdfPCell.NO_BORDER);
					cell.addElement(image);
				} catch (Exception e) {
					System.out.println("[error] 无法生成图片：" + imgFile + ": " + e.getMessage());
					e.printStackTrace();
				}
			}
		};
		helper.setImgByUrl(imgFile);
		pdfPTable.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
		pdfPTable.addCell(cell);
		pdfPTable.setSpacingAfter(5);
		return pdfPTable;
	}

	private Element codeParagraph(ValuePart[] valueParts) throws DocumentException {

		String value = valueParts[0].getValue();
		BlockType blockType = ArrayUtils.isEmpty(valueParts[0].getTypes()) ? null : valueParts[0].getTypes()[0];
		if (BlockType.CODE_XML.equals(blockType)) {
			return xmlCodeParagraph(value);
		}
		Paragraph p = new Paragraph(value, new Font(bfChinese, 12));

		PdfPTable pdfPTable = new PdfPTable(1);
		pdfPTable.setWidthPercentage(100);

		PdfPCell cell = new PdfPCell();
		cell.addElement(p);
		cell.setBorder(Rectangle.BOX);
		cell.setPaddingBottom(12);
		cell.setPaddingLeft(12);
		cell.setPaddingRight(12);
		cell.setBackgroundColor(new BaseColor(248, 248, 248));
		cell.setBorderColor(new BaseColor(231, 234, 237));
		pdfPTable.addCell(cell);
		pdfPTable.setSpacingAfter(5);
		return pdfPTable;
	}

	private Element xmlCodeParagraph(String value) {
		BaseFont xmlFont = null;
		try {
			xmlFont = bfChinese;
		} catch (Exception e) {
			e.printStackTrace();
		}

		Paragraph p = new Paragraph(value, new Font(xmlFont, 10));

		PdfPTable pdfPTable = new PdfPTable(1);
		pdfPTable.setWidthPercentage(100);

		PdfPCell cell = new PdfPCell();
		cell.addElement(p);
		cell.setBorder(Rectangle.BOX);
		cell.setPaddingBottom(12);
		cell.setPaddingLeft(12);
		cell.setPaddingRight(12);
		cell.setBackgroundColor(new BaseColor(248, 248, 248));
		cell.setBorderColor(new BaseColor(231, 234, 237));
		pdfPTable.addCell(cell);

		pdfPTable.setSpacingBefore(6F);
		pdfPTable.setSpacingAfter(6F);
		return pdfPTable;
	}

	private List<Element> quoteParagraph(List<Block> listData) {
		boolean isFirst = true;
		List<Element> results = new ArrayList<Element>();
		for (int i = 0; i < listData.size(); i++) {
			Block block = listData.get(i);
			if (i > 0) {
				isFirst = false;
			}
			Element element = quoteParagraph(block.getValueParts(), isFirst);
			results.add(element);
		}
		return results;
	}

	private Element quoteParagraph(ValuePart[] valueParts, boolean isFirst) {
		Paragraph p = new Paragraph();
		for (ValuePart valuePart : valueParts) {
			BlockType[] types = valuePart.getTypes();
			Font font = new Font(bfChinese);
			if (types != null) {
				for (BlockType type : types) {
					formatByType(font, type, valuePart.getLevel());
				}
			}
			Chunk chunk = new Chunk(valuePart.getValue(), font);
			p.add(chunk);
		}

		PdfPTable pdfPTable = new PdfPTable(2);

		try {
			pdfPTable.setWidthPercentage(100);
			pdfPTable.setWidths(new int[] { 1, 20 });

			try {
				PdfPCell cell = new PdfPCell();
				if (isFirst) {
					InputStream is = PDFDecorator4x.class.getResourceAsStream("/quote_char.jpg");
					Image image = Image.getInstance(MD2FileUtil.inputStream2ByteArrayOutputStream(is).toByteArray());
					cell.addElement(image);
				} else {
					cell.addElement(new Chunk());
				}
				cell.setBorder(PdfPCell.NO_BORDER);
				pdfPTable.addCell(cell);
			} catch (Exception e) {
				e.printStackTrace();
			}

			PdfPCell cell = new PdfPCell();
			cell.addElement(p);
			cell.setBorder(PdfPCell.NO_BORDER);
			if (isFirst) {
				cell.setPaddingTop(10);
			}
			cell.setPaddingBottom(5);
			pdfPTable.addCell(cell);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pdfPTable;
	}

	private Paragraph commonTextParagraph(ValuePart[] valueParts) {

		Paragraph p = new Paragraph();
		if (valueParts == null) {
			return p;
		}
		for (ValuePart valuePart : valueParts) {
			BlockType[] types = valuePart.getTypes();
			Font font = new Font(bfChinese, 10);
			boolean hasImg = false;
			if (types != null) {
				for (BlockType type : types) {
					if (type == BlockType.IMG) {
						hasImg = true;
						break;
					}
					formatByType(font, type, valuePart.getLevel());
				}
			}
			if (hasImg) {
				p.add(imgParagraph(valuePart));
			} else {
				Chunk chunk = new Chunk(valuePart.getValue(), font);

				Paragraph paragraph = new Paragraph();
				// 首行缩进
				paragraph.setFirstLineIndent(19.5F);
				// 行间距
				paragraph.setLeading(15F);
				paragraph.setSpacingBefore(6F);
//				int[] spacs = getHeaderSpacing(level);
//				paragraph.setSpacingBefore(spacs[0]);
//				paragraph.setSpacingAfter(spacs[1]);
				paragraph.add(chunk);
				p.add(paragraph);
			}
		}

		p.setSpacingAfter(5);

		return p;
	}

	private void formatByType(Font font, BlockType type, int level) {
		switch (type) {
		case BOLD_WORD:
			font.setStyle(Font.BOLD);
			break;
		case ITALIC_WORD:
			font.setStyle(Font.ITALIC);
			break;
		case STRIKE_WORD:
			font.setStyle(Font.STRIKETHRU);
			break;
		case CODE_WORD:
			font.setColor(BaseColor.RED);
			break;
		case HEADLINE:
			font.setSize(16);
			font.setStyle(Font.BOLD);
			break;
		default:
			break;
		}
	}
}
