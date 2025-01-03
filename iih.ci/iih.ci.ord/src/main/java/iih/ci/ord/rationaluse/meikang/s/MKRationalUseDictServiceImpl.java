package iih.ci.ord.rationaluse.meikang.s;

import java.util.List;
import java.util.Map;

import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.rationaluse.meikang.i.IMKRationalUseDictService;
import iih.ci.ord.rationaluse.meikang.s.qry.MKRationalUseQrySqlConst;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces = { IMKRationalUseDictService.class }, binding = Binding.JSONRPC)
public class MKRationalUseDictServiceImpl implements IMKRationalUseDictService {

	/*@Override
	public String DictRoute() throws BizException {
		IMedusageRService service = ServiceFinder.find(IMedusageRService.class);
		MedUsageDO[] usages = service.find("1=1", "", FBoolean.FALSE);
		// MKWsDrugRouteDTO dto = new MKWsDrugRouteDTO();
		// dto.setHiscode("0");
		// dto.setRoutecode(usages[0].getName());
		// dto.setRoutename(usages[0].getName());
		// rationalList.add(dto);
		StringBuilder sb = new StringBuilder();
		sb.append("<MESSAGE>");
		sb.append("<ReturnCode>"+(usages==null?0:usages.length)+"</ReturnCode>");
		sb.append("<ErrorMessage></ErrorMessage>");
		sb.append("<Data>");
		sb.append("<Rows>");
		if (usages != null) {
			for (MedUsageDO usage : usages) {
				sb.append("<Row>");
				sb.append("<hiscode>0</hiscode>");
				sb.append("<routecode>" + usage.getName() + "</routecode>");
				sb.append("<routename>" + usage.getName() + "</routename>");
				sb.append("</Row>");
			}
		}
		sb.append("</Rows>");
		sb.append("</Data>");
		sb.append("</MESSAGE>");

		return sb.toString();
	}*/
	@Override
	public String DictRoute() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTROUTE, null));
	}
	@Override
	public String DictDept() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDEPT, null));
	}

	@Override
	public String DictDoctor() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDOCTOR, null));
	}

	@Override
	public String DictDrug() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDRUG, null));
	}

	@Override
	public String DictDisease() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDISEASE, null));
	}

	@Override
	public String DictFrequency() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTFREQUENCY, null));
	}

	@Override
	public String DictAllergen() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTALLERGEN, null));
	}

	@Override
	public String DictCostItem() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTCOSTITEM, null));
	}

	@Override
	public String DictOperation() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTOPERATION, null));
	}

	@Override
	public String DrugStorage(String startdate, String enddate) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DRUGSTORAGE, param));
	}
	
	@Override
	public String DrugStorage(String startdate, String enddate,String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(startdate);
		param.addParam(enddate);
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DRUGSTORAGE_NEW, param));
	}

	@Override
	public String DictLab() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTLAB, null));
	}

	@Override
	public String DictLabItem() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTLABITEM, null));
	}

	@Override
	public String DictExam() throws BizException {
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTEXAM, null));
	}
	@Override
	public String DictRoute_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTROUTE_NEW, param));
	}
	@Override
	public String DictDept_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDEPT_NEW, param));
	}
	@Override
	public String DictDoctor_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDOCTOR_NEW, param));
	}
	@Override
	public String DictDrug_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDRUG_NEW, param));
	}
	@Override
	public String DictDisease_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		List<Map<String, Object>> list = CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDISEASE_NEW, param);
		int size =(list == null ? 0 : list.size());
		return CiOrdUtils.MKQryInfoTransToXML1(orgcode,size);
	}
	@Override
	public String DictFrequency_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTFREQUENCY_NEW, param));
	}
	@Override
	public String DictAllergen_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTALLERGEN_NEW, param));
	}
	@Override
	public String DictCostItem_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		List<Map<String, Object>> list = CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTCOSTITEM_NEW, param);
		int size =(list == null ? 0 : list.size());
		return CiOrdUtils.MKQryInfoTransToXML1(orgcode,size);
	}
	@Override
	public String DictOperation_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTOPERATION_NEW, param));
	}
	@Override
	public String DictLab_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTLAB_NEW, param));
	}
	@Override
	public String DictLabItem_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTLABITEM_NEW, param));
	}
	@Override
	public String DictExam_Orgcode(String orgcode) throws BizException {
		SqlParam param = new SqlParam();
		param.addParam(orgcode);
		return CiOrdUtils.MKQryInfoTransToXML(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTEXAM_NEW, param));
	}
	/**
	 * 分页查询疾病字典信息
	 */
	@Override
	public String DictDiseasePage(String orgcode, int pageNum, int pageSize) throws BizException {
		if (pageNum!=0 ) {
			if (pageSize==0) {
				pageSize=10000;
			}
			int start=(pageNum-1)*pageSize;
			int end =pageNum*pageSize;
			SqlParam param = new SqlParam();
			param.addParam(orgcode);
			List<Map<String, Object>> list=CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDISEASE_NEW, param);
			int totalCount = list.size();//总数
			int totalPage=0;//总页数
			if (totalCount%pageSize==0) {
				totalPage=totalCount/pageSize;
			}else{
				totalPage=totalCount/pageSize+1;
			}
			param.addParam(end);
			param.addParam(start);
			return CiOrdUtils.MKQryInfoTransToXML1(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTDISEASE_PAGE, param),totalCount,totalPage);
		}else {//若不传当前页数和每页 显示条数的话，只查询该组织下的数量
			return DictDisease_Orgcode(orgcode);
		}
		
		
	}
	@Override
	public String DictCostItem_Page(String orgcode, int pageNum, int pageSize) throws BizException {
		if (pageNum!=0 ) {
			if (pageSize==0) {
				pageSize=10000;
			}
			int start=(pageNum-1)*pageSize;
			int end =pageNum*pageSize;
			SqlParam param = new SqlParam();
			param.addParam(orgcode);
			List<Map<String, Object>> list=CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTCOSTITEM_NEW, param);
			int totalCount = list.size();//总数
			int totalPage=0;//总页数
			if (totalCount%pageSize==0) {
				totalPage=totalCount/pageSize;
			}else{
				totalPage=totalCount/pageSize+1;
			}
			param.addParam(end);
			param.addParam(start);
			return CiOrdUtils.MKQryInfoTransToXML1(CiOrdUtils.DAFacadeQry(MKRationalUseQrySqlConst.getSql().DICTCOSTITEM_Page, param),totalCount,totalPage);
		}else {//若不传当前页数和每页 显示条数的话，只查询该组织下的数量
			return DictCostItem_Orgcode(orgcode);
		}
	}
	
}
