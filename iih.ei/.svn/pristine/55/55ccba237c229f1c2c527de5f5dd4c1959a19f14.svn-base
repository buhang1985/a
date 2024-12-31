package iih.ei.itf.md2;

import java.io.File;

import org.apache.commons.io.FileUtils;

import iih.ei.itf.eiitfcate.s.bp.MDFileBuilder;
import iih.ei.itf.md2.export.FileFactory;

public class Test {

	public static void main(String[] args) {

		try {
			
			MDFileBuilder builder = new MDFileBuilder();
			builder.appendH1("1 SI0001 获取门诊排班列表");
			builder.appendH3("1.4入参说明");
			builder.appendH4("Data节点");

			String[][] table = new String[2][6];

			table[0] = new String[] { "序号", "参数", "名称", "类型", "是否可空", "备注" };
			table[1] = new String[] { "1", "Code_dep", "", "String", "Y", "" };

			builder.appendTable(table);
			builder.appendTable(table);
			builder.appendTable(table);

			String code = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<iihparam>\r\n" + "<Data>\r\n"
					+ "<Pageinfos>\r\n" + "<Pageinfo>\r\n" + " <Pagesize>4</Pagesize>\r\n"
					+ " <Pageindex>1</Pageindex>\r\n" + "</Pageinfo>\r\n" + "</Pageinfos>\r\n" + "   <Dept_code/>\r\n"
					+ "   <Res_name/>	\r\n" + "   <Begin_date>2019-09-21</Begin_date>	\r\n"
					+ "  <End_date>2019-09-29</End_date>\r\n" + "  <Srvtp_code/>\r\n" + "  <Chltp_code/>\r\n"
					+ " </Data>\r\n" + "</iihparam>";
			builder.appendCode(MDFileBuilder.CODE_TYPE_XML, code);

			File mdFile = new File("C:\\Users\\hao_wu\\Desktop\\SI0001.md");
			String pdfFilePath = "C:\\Users\\hao_wu\\Desktop\\SI0001-1.pdf";

			String mfFileContent = FileUtils.readFileToString(mdFile);
			mfFileContent = builder.toString();

			byte[] bytes = FileFactory.producePdf(mfFileContent);

			new File(pdfFilePath).delete();
			
			FileUtils.writeByteArrayToFile(new File(pdfFilePath), bytes);

//			
//			String htmlFilePath = "C:\\Users\\hao_wu\\Desktop\\功能节点开发教程-1.html";
//			FileFactory.produce(mdFile, pdfFilePath);

			Runtime.getRuntime().exec("rundll32 url.dll FileProtocolHandler " + pdfFilePath);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
