package iih.ci.ord.s.ems.op.pres;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dto.ordpres.d.OrdPresDTO;
import iih.ci.ord.dto.ordpres.d.PresDrugDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.PresLoadDTO;
import iih.ci.ord.i.meta.PresOrderDTO;
import iih.ci.ord.i.meta.PresRstDTO;
import iih.ci.ord.s.ems.itf.bp.IPresLoadBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 处方数据家在逻辑
 * 
 * @author wangqingzhu
 *
 */
public class PresLoadBP implements IPresLoadBP {

	/**
	 * 获取处方信息
	 */
	@Override
	public PresRstDTO load(CiEnContextDTO ctx, PresLoadDTO ld) throws BizException {
	
		// 查询处方信息
		StringBuilder sb = new StringBuilder();
		sb.append(
				" select A.Id_Pres,A.Id_Prestp,A.sd_prestp,D.Name as name_prestp,A.name,A.code,A.Sd_Srvtp,A.sd_prestpword,A.Fg_Dispense,");
		sb.append(" J.NAME as name_dep_mp,E.NAME as name_dep_or,F.Name as name_emp_or,D.ctrl1 as Fg_poisonhemp ");
		sb.append(" from ci_pres A ");
		sb.append(" left join bd_udidoc D on A.Id_Prestp=D.Id_Udidoc ");
		sb.append(" left join bd_dep E on A.Id_Dep_Or = E.Id_Dep ");
		sb.append(" left join bd_psndoc F on a.id_emp_or = F.ID_PSNDOC ");
		sb.append(" left join bd_dep J on A.Id_Dep_mp = J.Id_Dep ");
		sb.append(String.format(" where A.Id_En='%s' ", ctx.getId_en()));
		DAFacade dao = new DAFacade();
		List<OrdPresDTO> listOrdPresInfo = (List<OrdPresDTO>) dao.execQuery(sb.toString(),
				new BeanListHandler(OrdPresDTO.class));
		if (null == listOrdPresInfo || listOrdPresInfo.size() == 0) {
			return null;
		}
		// 获取所有的处方ID集合，并组织为特定查询条件
		StringBuilder sbPresID = new StringBuilder();
		for (OrdPresDTO orderPresInfo : listOrdPresInfo) {
			sbPresID.append(",").append(orderPresInfo.getId_pres());
		}
		// 获取所有处方下的明细信息集合
		sb = new StringBuilder();
		sb.append(
				" select B.id_pres,B.Name as name_srv,D.Name as name_unit_med,B.Quan_Medu as quan_med,B.Id_Freq,E.Name as name_freq,F.Name as name_route,G.Name as name_routedes,");
		sb.append(" H.Name as name_boil,I.Name as name_boildes, ");
		sb.append(" C.Price_Pgku_Cur as price,J.Name as name_mm,J.Spec as spec_mm, ");
		sb.append(" D1.Name as name_unit_sale,C.quan_cur,K.Days_Or as use_day,B.Sortno ");
		sb.append(" from ci_or_srv B  ");
		sb.append(" left outer join ci_or_srv_mm C on B.Id_Orsrv = C.Id_Orsrv ");
		sb.append(" left outer join bd_mm J ON C.Id_Mm=J.Id_Mm ");
		sb.append(" left outer join bd_measdoc D on B.Id_Medu = D.Id_Measdoc ");
		sb.append(" left outer join bd_measdoc D1 on C.Id_Pgku_Cur = D1.Id_Measdoc ");
		sb.append(" left outer join bd_freq E on B.Id_Freq = E.Id_Freq ");
		sb.append(" left outer join bd_route F on B.id_route = F.Id_Route ");
		sb.append(" left outer join bd_route_des G on B.Id_Routedes = G.Id_Routedes ");
		sb.append(" left outer join bd_boil H on B.Id_Boil = H.Id_Boil ");
		sb.append(" left outer join bd_boil_des I on B.Id_Boildes = I.Id_Boildes ");
		sb.append(" left outer join ci_order K on B.Id_Or = K.Id_Or ");
		sb.append(String.format(" where B.Id_Pres in ('%s')   ", sbPresID.substring(1).replace(",", "','")));
		List<PresDrugDTO> listPresDrugs = (List<PresDrugDTO>) dao.execQuery(sb.toString(),
				new BeanListHandler(PresDrugDTO.class));
		if (null == listPresDrugs || listPresDrugs.size() == 0) {
			return null;
		}
		// 创建返回值对象
		PresRstDTO rstInfo = new PresRstDTO();
		rstInfo.setDocument(new FArrayList());
		// 定义临时结构
		List<OrdPresDTO> wPresList = new ArrayList<OrdPresDTO>();
		List<OrdPresDTO> hPresList = new ArrayList<OrdPresDTO>();
		// 内存处理，将所有的处方明细匹配到处方结构中
		for (OrdPresDTO orderPresInfo : listOrdPresInfo) {
			// 草药类型的处方与其他处方不同
			if (orderPresInfo.getSd_srvtp().startsWith("0103")) {
				hPresList.add(orderPresInfo);
			} else {
				wPresList.add(orderPresInfo);
			}

			// 分拣处方明细条目
			FArrayList presDrugList = new FArrayList();
			for (PresDrugDTO presDrugInfo : listPresDrugs) {
				if (((OrdPresDTO) orderPresInfo).getId_pres().equals(presDrugInfo.getId_pres())) {
					presDrugList.add(presDrugInfo);
				}
			}
			orderPresInfo.setPresdrugs(presDrugList);

		}
		// 西药处方信息放到第一个
		FArrayList wRstList = new FArrayList();
		for (OrdPresDTO orderPresInfo : wPresList) {
			wRstList.add(presOrderDTOFrom(orderPresInfo));
		}
		// 草药处方放到第二个
		rstInfo.getDocument().add(wRstList);
		FArrayList hRstList = new FArrayList();
		for (OrdPresDTO orderPresInfo : hPresList) {
			hRstList.add(presOrderDTOFrom(orderPresInfo));
		}
		rstInfo.getDocument().add(hRstList);
		// 返回值信息
		return rstInfo;
	}

	/**
	 * 构建处方列表UI模型对象信息
	 * 
	 * @param orderPresInfo
	 * @return
	 */
	private PresOrderDTO presOrderDTOFrom(OrdPresDTO orderPresInfo) {
		// 定义处方结构显示模型对象
		PresOrderDTO presOrderInfo = new PresOrderDTO();
		// 构建
		String strCaption = String.format(" 处方号:%s", orderPresInfo.getCode());
		strCaption += String.format("  处方类型:%s", orderPresInfo.getName_prestp());
		strCaption += String.format("  金额:%f元", getPressItemsTotalPrice(orderPresInfo));
		strCaption += String.format("  取药地点:%s", orderPresInfo.getName_dep_mp());
		strCaption += String.format("  医生:%s", orderPresInfo.getName_emp_or());

		presOrderInfo.setTitle(strCaption);
		presOrderInfo.setItemList(orderPresInfo.getPresdrugs());
		if (FBoolean.TRUE.equals(presOrderInfo.getFg_poisonhemp())) {
			presOrderInfo.setFg_poisonhemp(FBoolean.TRUE);
			presOrderInfo.setColor_poisonhemp(new Color(236, 152, 186).toString());
		} else {
			presOrderInfo.setFg_poisonhemp(FBoolean.FALSE);
		}
		return presOrderInfo;
	}

	/**
	 * 计算处方费用
	 * 
	 * @param opd
	 * @return
	 */
	private double getPressItemsTotalPrice(OrdPresDTO opd) {
		if (null == opd) {
			return 0;
		}
		double totalPrice = 0;
		// 遍历所有的处方明细项目，累加单项金额
		for (Object obj : opd.getPresdrugs()) {
			PresDrugDTO drug = (PresDrugDTO) obj;
			if (null != drug.getQuan_cur() && drug.getPrice() != null)
				totalPrice += drug.getQuan_cur().multiply(drug.getPrice()).doubleValue();
		}
		return totalPrice;
	}
}
