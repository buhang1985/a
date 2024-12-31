package iih.ci.ord.s.external.outqry.bp;

import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import iih.ci.ord.s.external.blood.ruimei.s.bp.ApiUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertXml2DTOsUtils;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

public class CiOutQueryUtils {
	/**
	 * 医嘱信息查询基本sql
	 * @return
	 */
	public static String getOrdInfoBaseSql() {
		return "select ci_order.id_en id_ent, ci_order.code_or,ci_order.code_or||ci_or_srv.sortno code_or_itm,ci_order.dt_effe,ci_order.days_or,ci_order.fg_urgent,ci_order.sd_srvtp,srvtp.name name_srvtp,bd_srvca.code code_srvca,"
				+ "bd_srvca.name name_srvca,ci_order.dt_entry,ci_order.fg_sign,ci_order.fg_canc," + 
				"ci_order.orders,ci_order.sd_su_bl,ci_order.sd_su_or,suor.name name_su_or,ci_or_srv.code_srv code_or_srv,ci_or_srv.name name_or_srv,ci_order.name_or shortname,"
				+ "bd_mm.spec spec,ci_or_srv.fg_propc fg_propc,ci_or_srv.quan_medu quan_medu," + 
				"ci_or_srv_mm.quan_medu_cur quan_medu_cur,ci_or_srv_mm.factor_cur factor_cur,ci_or_srv_mm.quan_cur,ci_or_srv.fg_skintest,ci_or_srv.pri,"
				+ "ci_or_srv.sd_hpsrvtp,ci_or_srv.fg_selfpay," + 
				"ci_or_srv.fg_specill,bd_mm.sup_name,ci_pres.code code_pres,dep1.code code_wh,med.code code_medu,bd_mm.printname printname,"
				+ "bd_freq.code code_freq,bd_route.code code_route," + 
				"bd_route.name name_route,pgku.code code_pgku_cur,medcur.code code_medu_cur,dep2.code code_dep_mp,dep2.name name_dep_mp,dep3.code code_dep_or,"
				+ "dep3.name name_dep_or,dep4.name name_dep_nur_or," + 
				"psn1.code code_emp_or,psn1.name name_emp_or,psn2.code code_emp_sign,psn2.name name_emp_sign,psn3.name name_emp_canc,psn3.code code_emp_canc,"
				+ "bd_route.code code_route,bd_route.name name_route," + 
				"ci_or_srv.fg_research fg_research,ci_or_srv.code_researchproject code_researchproject,ci_skin_test.sd_rst_skintest sd_rst_skintest,"
				+ "ci_or_srv.sd_nodispense sd_nodispense ,ci_order.fg_vip,dep5.code code_dep_sign,dep5.name name_dep_sign " + 
			//	" ,mp_ne_lab_samp.no_bar no_bar" + 
				"  from ci_order ci_order " + 
				"  left join ci_or_srv ci_or_srv " + 
				"    on ci_order.id_or = ci_or_srv.id_or " + 
				"    left join ci_or_srv_mm ci_or_srv_mm on ci_or_srv_mm.id_orsrv=ci_or_srv.id_orsrv " + 
				"    left join bd_mm bd_mm on bd_mm.id_mm=ci_or_srv_mm.id_mm " + 
				"    left join bd_freq bd_freq on bd_freq.id_freq=ci_order.id_freq " + 
				"    left join bd_route bd_route on bd_route.id_route = ci_order.id_route " + 
				"    left join ci_pres ci_pres on ci_pres.id_pres=ci_or_srv.id_pres " + 
				"    left join bd_srvca bd_srvca on bd_srvca.id_srvca=ci_order.id_srvca " + 
				"    left join bd_dep dep1 on dep1.id_dep=ci_or_srv.id_dep_wh " + 
				"    left join bd_dep dep2 on dep2.id_dep=ci_order.id_dep_mp " + 
				"    left join bd_dep dep3 on dep3.id_dep=ci_order.id_dep_or " + 
				"    left join bd_dep dep4 on dep4.id_dep=ci_order.id_dep_nur_or " + 
				"    left join bd_dep dep5 on dep5.id_dep=ci_order.id_dep_sign "+
				"    left join bd_psndoc psn1 on psn1.id_psndoc=ci_order.id_emp_or " + 
				"    left join bd_psndoc psn2 on psn2.id_psndoc=ci_order.id_emp_sign " + 
				"    left join bd_psndoc psn3 on psn3.id_psndoc=ci_order.id_emp_canc " + 
				"    left join bd_measdoc med on ci_or_srv.id_medu=med.id_measdoc " + 
				"    left join bd_measdoc pgku on pgku.id_measdoc=ci_or_srv_mm.id_pgku_cur " + 
				"    left join bd_measdoc medcur on medcur.id_measdoc=ci_or_srv_mm.id_medu_cur " + 
				"    left join bd_udidoc srvtp on srvtp.id_udidoc=ci_order.id_srvtp  " + 
				"    left join bd_udidoc suor on suor.id_udidoc=ci_order.id_su_or " + 
				"    left join bd_route bd_route on bd_route.id_route=ci_order.id_route " + 
				"    left join ci_skin_test ci_skin_test on ci_skin_test.id_or=ci_order.id_or " ; 
			//	" --   left join mp_or_pr mp_or_pr on mp_or_pr.id_or=ci_order.id_or " + 
			//	" --  left join mp_ne_lab_samp_itm_ref on mp_ne_lab_samp_itm_ref.id_or_pr=mp_or_pr.id_or_pr " + 
			//	" --  left join mp_ne_lab_samp mp_ne_lab_samp on mp_ne_lab_samp.id_labsamp=mp_ne_lab_samp_itm_ref.id_labsamp ";
	}
	/**
	 * 门诊患者基本信息
	 * @return
	 */
	public static String getOpPatInfoBaseSql() {
		return " select en_ent.id_ent id_ent, en_ent.code code_en, en_ent.code_entp code_entp,pi_pat.code code_pat,en_ent_op.times_op times_en,pi_pat.name name_pat,en_ent.sd_sex_pat sd_sex_pat,sex.name name_sex_pat,pi_pat.dt_birth dt_birth_pat, " + 
				" pi_pat.sd_idtp sd_idtp,pi_pat.id_code,pi_pat.mob mob,en_ent.dt_acpt dt_enacpt,bd_pri_pat.code pri_pat_code,bd_pri_pat.name pri_pat_name, " + 
				" dep1.code code_dep_phy,dep2.code code_dep_nur,empphy.code code_emp_phy,empnur.code code_emp_nur,bd_org.code code_org,bd_grp.code code_grp,idtp.name name_idtp " + 
				" from en_ent en_ent " + 
				" left join en_ent_op en_ent_op on en_ent.id_ent=en_ent_op.id_ent " + 
				" left join pi_pat pi_pat on en_ent.id_pat=pi_pat.id_pat " + 
				" left join bd_pri_pat bd_pri_pat on en_ent.id_pripat=bd_pri_pat.id_pripat " + 
				" left join bd_dep dep1 on dep1.id_dep=en_ent.id_dep_phy " + 
				" left join bd_dep dep2 on dep2.id_dep=en_ent.id_dep_nur " + 
				" left join bd_psndoc empphy on empphy.id_psndoc=en_ent.id_emp_phy " + 
				" left join bd_psndoc empnur on empnur.id_psndoc=en_ent.id_emp_nur " + 
				" left join bd_org bd_org on bd_org.id_org=en_ent.id_org " + 
				" left join bd_grp bd_grp on bd_grp.id_grp=en_ent.id_grp " + 
				" left join bd_udidoc sex on sex.id_udidoc=en_ent.id_sex_pat " + 
				" left join bd_udidoc idtp on idtp.id_udidoc=pi_pat.id_idtp ";
	}
	
	public static Boolean isStrEmpty(String val) {
		if(val==null||val.trim().length()==0)
			return true;
		return false;
	}
	/**
	 * 实例化Document对象，增加
	 * 
	 * @return
	 * @throws BizException
	 */
	public static Document getDocumentObj() throws BizException {
		return ApiUtils.getDocumentObj();
	}
	
	/**
	 * 实例化结果信息，并返回根节点
	 * 
	 * @param document
	 * @return
	 */
	public static Element initTitle(Document document, HashMap<String, Element> reMap) {

		// 根节点
		Element root = document.createElement("result");
		document.appendChild(root);

		// title节点
		Element titleRoot = document.createElement("result_title");
		root.appendChild(titleRoot);

		// title内容节点
		Element eleCode = document.createElement("code");
		eleCode.setTextContent("0");
		Element eleMsg = document.createElement("message");
		eleMsg.setTextContent("");
		titleRoot.appendChild(eleCode);
		titleRoot.appendChild(eleMsg);

		reMap.put("code", eleCode);
		reMap.put("message", eleMsg);

		return root;
	}
	
	public static String conversionXml_new(Document document,Element root, BaseDTO[] params) throws BizException {
		ConvertDTOs2XmlUtils bp = new ConvertDTOs2XmlUtils();
		return bp.exec( params,root,document);
	}
	
	public static String conversionXml_new2(Document document,Element root, BaseDTO[] params) throws BizException {
		ConvertDTOs2XmlUtils bp = new ConvertDTOs2XmlUtils();
		return bp.exec2( params,root,document);
	}
	
	/**
	 * 解析Xml至DTO
	 * 
	 * @param xamParam
	 * @param classInfo
	 * @return
	 * @throws BizException
	 */
	public static <T extends BaseDTO> BaseDTO PraseXmlToDTO(String xamParam, Class<T> classInfo) throws BizException {
		ConvertXml2DTOsUtils bp = new ConvertXml2DTOsUtils();
		return bp.exec(xamParam, classInfo);
	}
	
	public static String getErrMsg(String msg) {
		// 2、创建Document对象
				Document document;
				try {
					document = getDocumentObj();
					// 3、实例化Title，返回title节点
					HashMap<String, Element> mapEle = new HashMap<String, Element>();
					Element root = initTitle(document, mapEle);
					mapEle.get("code").setTextContent("1");
					mapEle.get("message").setTextContent(msg);
					return getXmlStr(document);
				} catch (BizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            return null;
			
	}
	
	/**
	 * 生成xml字符串
	 * 
	 * @param document
	 * @return
	 * @throws BizException
	 */
	public static String getXmlStr(Document document) throws BizException {
		return ApiUtils.getXmlStr(document);
	}

}
