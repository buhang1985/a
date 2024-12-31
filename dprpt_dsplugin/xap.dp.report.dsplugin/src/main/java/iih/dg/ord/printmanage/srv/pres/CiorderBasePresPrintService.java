package iih.dg.ord.printmanage.srv.pres;

import iih.ci.ord.printmanage.dto.QRCodeParamDTO;
import iih.ci.ord.printmanage.qrcode.QRCodeFactory;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;
import iih.dg.ord.printmanage.srv.d.OrdPresDTO;
import iih.dg.ord.printmanage.srv.d.PresDrugDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 处方打印单查询服务类
 * @author Young
 *
 */
public class CiorderBasePresPrintService implements ICiorderPrintService<OrdPresDTO, PresDrugDTO> {

	protected String Bl_State = ICiorderPrintConst.BLSTATE_UNPAID;
	
	/**
	 * 
	 */
	@Override
	public List<OrdPresDTO> exec(String ids) throws Exception{
		return null;
	}
	
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrdPresDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		this.Bl_State = blstatetp;
		return this.exec(ids);
	}
	
	/**
	 * 
	 */
	@Override
	public String getOrdInfoSqlQry(String ids){
		return "";
	}
	/**
	 * 获取二维码
	 * @code 
	 * @author LiYue
	 * @date 2019年4月25日,上午9:57:02
	 * @return
	 */
	public String getQRCode(String ids) {
		if (StringUtils.isNullOrEmpty(ids))return "";
		String[]  strs=ids.split(",");
		String id = strs[0];
		String sqlParam = " select org.CODE as orgcode,pat.code as patCode,en.code as entpCode from ci_pres ord " + 
				" left JOIN BD_ORG org on org.id_org = ord.id_org " + 
				" left join pi_pat pat on pat.id_pat = ord.id_pati " + 
				" left join en_ent en on en.id_ent = ord.id_en " + 
				" where id_pres in ("+ids+" )";
		 String QRcode ;
		try {
			QRCodeParamDTO result = CiorderPrintUtils.GetQueryBeanResulte(QRCodeParamDTO.class, sqlParam);
			QRCodeFactory codeFact = new QRCodeFactory();
			QRcode = codeFact.creatQRCode(result);
		} catch (Exception e) {
			return " ";
		}
		return QRcode;
	}
	/**
	 * 获取医嘱处方信息
	 * @param sqlQry
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrdPresDTO> getOrderList(String sqlQry) throws Exception{
		List<OrdPresDTO> result=CiorderPrintUtils.GetQueryResulte(OrdPresDTO.class, sqlQry);
		return result;
	}
	
	@Override
	public String getItmInfoSqlQry(String ids){
		return "";
	}
	
	/**
	 * 获取处方药品信息
	 * @param sqlQry
	 * @throws BizException
	 */
	@Override
	public List<PresDrugDTO> getItemList(String sqlQry) throws Exception {
		List<PresDrugDTO> result=CiorderPrintUtils.GetQueryResulte(PresDrugDTO.class, sqlQry);
		return result;
	}
	
	
	
	@Override
	public void setOrdInfo(List<OrdPresDTO> dtos) throws Exception{
		//需要计算代煎费的处方对应的id_or集合
		List<String> idors = new ArrayList<String>();
		//需要计算代煎费的处方和医嘱之间的对应关系
		Map<String,OrdPresDTO> orPresMapping = new HashMap<String,OrdPresDTO>();
		
		//需要计算煎药辅料费的处方对应的id_or集合
		List<String> boildes_idors = new ArrayList<String>();
		//需要计算煎药辅料费的处方和医嘱之间的对应关系
		Map<String,OrdPresDTO> boildes_orPresMapping = new HashMap<String,OrdPresDTO>();
		
		for(OrdPresDTO dto:dtos){
			//设置年龄（格式）
			if(dto.getDt_birth()!=null){
				Date birth=new Date();
				birth=CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
				FDate dt=new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}
			//设置过敏史
			if(dto.getId_pati()!=null){
				String des_alcla=CiorderPrintUtils.GetPatalcla(dto.getId_pati());
				dto.setDes_alcla(des_alcla);
			}
			
			List<PresDrugDTO> drugdtos=dto.getPresDrugList();
			if(drugdtos!=null && drugdtos.size()>0){
				//
				dto.setOrders(drugdtos.get(0).getOrders());
				
				//*********************************************************//
				/**
				 * 用法描述截取字符串去掉 全部显示用法的描述字段
				 * (郑州骨伤科医院需求)bug：127039
				 *	liyuelong 2018-07-23
				 */
				/*dto.setDes_or(StringUtils.isNullOrEmpty(drugdtos.get(0).getDes_or()) || drugdtos.get(0).getDes_or().length() < 30 ? drugdtos.get(0).getDes_or()
						: drugdtos.get(0).getDes_or().substring(0, 30));*/
				
				dto.setDes_or(drugdtos.get(0).getDes_or());
				//*********************************************************//
				
				dto.setName_freq(drugdtos.get(0).getName_freq());
				dto.setPsn_agent(drugdtos.get(0).getPsn_agent());
				dto.setIdno_agent(drugdtos.get(0).getIdno_agent());
				dto.setName_card_agent(drugdtos.get(0).getName_card_agent());
				dto.setFg_boil(drugdtos.get(0).isFg_boil());
				//总价
				FDouble atm_tatol=new FDouble("0.00");
				for(PresDrugDTO drugdto:drugdtos){
					if(!(drugdto.getPrice()==null || drugdto.getQuan_cur()==null)){
						atm_tatol=atm_tatol.add(drugdto.getPrice().multiply(drugdto.getQuan_cur()).setScale(-2, BigDecimal.ROUND_HALF_UP));
					}
				}
				atm_tatol = atm_tatol.setScale(-2, BigDecimal.ROUND_HALF_UP);
				dto.setAmt_total(atm_tatol);
			}
			//如果代煎标志为true,记录下处方，计算处方下的代煎费
			if(dto.isFg_boil()){
				if(drugdtos!=null && drugdtos.size()>0){
					idors.add(drugdtos.get(0).getId_or());
					orPresMapping.put(drugdtos.get(0).getId_or(), dto);
				}
			}
			//与代煎与否无关
			boildes_idors.add(drugdtos.get(0).getId_or());
			boildes_orPresMapping.put(drugdtos.get(0).getId_or(), dto);
			//设置皮试结果
			setSkinRst(dto, drugdtos);
		}
		//填充代煎费
		setPresBoilPrice(idors,orPresMapping);
		//计算煎法要求价格
		setPresBoildesPrice(boildes_idors,boildes_orPresMapping);
	}
	
	
	/**
	 * 根据医嘱id设置处方的煎药辅料费金额
	 * @param idors 草药医嘱id集合
	 * @param orPresMapping 处方map集合 key ：id_or, value : 处方对象
	 * @throws Exception
	 */
	private void setPresBoildesPrice(List<String> idors, Map<String, OrdPresDTO> orPresMapping) throws Exception {

		if (idors == null || idors.size() == 0) {
			return;
		}

		StringBuilder idOrBuilder = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		sb.append("select srv.id_or,sum(nvl(srv.pri,0)*nvl(srv.quan_total_medu,0)) as Price");
		sb.append(" from ci_or_srv srv where srv.eu_sourcemd='14' AND srv.fg_or= 'N' AND srv.fg_bl ='Y'");
		sb.append(" and srv.id_or in (");

		if (idors != null && idors.size() > 0) {
			for (String id_or : idors) {
				idOrBuilder.append(",'" + id_or + "'");
			}
		}
		sb.append(idOrBuilder.substring(1)).append(")");
		sb.append(" group by id_or");

		List<PresDrugDTO> presDrugs = CiorderPrintUtils.GetQueryResulte(PresDrugDTO.class, sb.toString());

		if (presDrugs != null && presDrugs.size() > 0) {
			for (PresDrugDTO presDrug : presDrugs) {
				if (orPresMapping.containsKey(presDrug.getId_or())) {
					
					double pri = presDrug.getPrice() != null ? presDrug.getPrice().doubleValue() : 0.0;
					orPresMapping.get(presDrug.getId_or()).setBoildesPrice(pri);
				}
			}
		}
	}

	/**
	 * 设置处方煎药费金额
	 * @param idors 计算煎药费医嘱id集合
	 * @param orPresMapping 处方map集合 key ：id_or, value : 处方对象
	 * @throws Exception
	 */
	private void setPresBoilPrice(List<String> idors, Map<String, OrdPresDTO> orPresMapping) throws Exception {

		if (idors == null || idors.size() == 0) {
			return;
		}

		StringBuffer idOrBuffer = new StringBuffer();
		StringBuffer qryBuffer = new StringBuffer();
		qryBuffer.append("select srv.id_or,sum(nvl(srv.pri,0)*nvl(srv.quan_total_medu,0)) as Price");
		qryBuffer.append(" from ci_or_srv srv where srv.eu_sourcemd='5' AND srv.fg_or= 'N' AND srv.fg_bl ='Y'");
		qryBuffer.append("and srv.id_or in (");

		for (String id_or : idors) {
			idOrBuffer.append(",'" + id_or + "'");
		}

		qryBuffer.append(idOrBuffer.substring(1)).append(")");
		qryBuffer.append(" group by id_or");

		List<PresDrugDTO> presDrugs = CiorderPrintUtils.GetQueryResulte(PresDrugDTO.class, qryBuffer.toString());

		for (PresDrugDTO presDrug : presDrugs) {
			if (orPresMapping.containsKey(presDrug.getId_or())) {
				//煎药费与付数无关
				//double pri_boil = presDrug.getPrice() != null ? presDrug.getPrice().doubleValue() : 0.0;
				int num = Integer.parseInt(orPresMapping.get(presDrug.getId_or()).getOrders_boil());
				//煎药费=每付的钱*付数
				double pri_boil = presDrug.getPrice() != null ? presDrug.getPrice().doubleValue()*num: 0.0;

				orPresMapping.get(presDrug.getId_or()).setPri_boil(pri_boil);
			}
		}
	}
	/**
	 * 按理说，一个处方中只会有一个需要皮试的药品，所以皮试结果回写到处方上了
	 * @param dto
	 * @param drugdtos
	 */
	private void setSkinRst(OrdPresDTO dto,List<PresDrugDTO> drugdtos){
		for(PresDrugDTO drug : drugdtos){
			if(!StringUtils.isNullOrEmpty(drug.getSd_rst_skintest())){
				dto.setSd_rst_skintest(drug.getSd_rst_skintest());
				return;
			}
		}
	}
}
