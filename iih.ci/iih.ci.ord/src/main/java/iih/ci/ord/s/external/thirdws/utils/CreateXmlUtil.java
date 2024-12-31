package iih.ci.ord.s.external.thirdws.utils;

import iih.ci.ord.external.blood.ruimei.d.Patientinfo;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuordDTO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbusrvDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsOrdDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsPresDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EmsDrugsSrvDTO;
import iih.ci.ord.i.external.thirdws.drugs.d.EntWsDrugsDTO;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
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
