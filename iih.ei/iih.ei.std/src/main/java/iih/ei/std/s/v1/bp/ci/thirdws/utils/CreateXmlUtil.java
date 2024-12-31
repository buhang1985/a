package iih.ei.std.s.v1.bp.ci.thirdws.utils;

import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuordDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbusrvDTO;
import xap.mw.core.data.BizException;

public class CreateXmlUtil {
	public static void main(String[] args) throws BizException{
		ConvertDTOs2XmlUtils utils = new ConvertDTOs2XmlUtils();
		System.out.println(utils.exec(new EmsapbuentDTO[]{new EmsapbuentDTO()}, "ent", ""));
		System.out.println(utils.exec(new EmsapbuordDTO[]{new EmsapbuordDTO()}, "order", ""));
		System.out.println(utils.exec(new EmsapbusrvDTO[]{new EmsapbusrvDTO()}, "srv", ""));
//		System.out.println(utils.exec(new EmsDrugsSrvDTO[]{new EmsDrugsSrvDTO()}, "root", ""));
	}
}
