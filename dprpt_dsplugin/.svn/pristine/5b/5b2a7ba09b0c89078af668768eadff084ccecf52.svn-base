package iih.ci.ord.printmanage.srv.ord;

import iih.ci.ord.printmanage.common.CiOrderPrintDiagService;
import iih.ci.ord.printmanage.dto.HeadDTO;
import iih.ci.ord.printmanage.dto.ItemDTO;
import iih.ci.ord.printmanage.dto.QRCodeParamDTO;
import iih.ci.ord.printmanage.qrcode.QRCodeFactory;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import iih.ci.ord.printmanage.srv.ICiorderPrintConst;
import iih.ci.ord.printmanage.srv.ICiorderPrintService;

import java.util.Date;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 申请单数据查询服务类
 * @author Young
 *
 */
public class CiorderBaseOrdPrintService implements ICiorderPrintService<HeadDTO, ItemDTO> {

	protected String Bl_State = ICiorderPrintConst.BLSTATE_UNPAID;
	
	/**
	 * 
	 */
	@Override
	public List<HeadDTO> exec(String ids) throws Exception {
		if (StringUtils.isNullOrEmpty(ids))return null;
		String ordqry = this.getOrdInfoSqlQry(ids);
		if (StringUtils.isNullOrEmpty(ordqry))return null;
		List<HeadDTO> ordlist = this.getOrderList(ordqry);
		if (ordlist == null || ordlist.size() == 0)return null;
		this.setOrdInfo(ordlist);
		return ordlist;
	}
	/**
	 * Id_or获取二维码
	 * @code 
	 * @author LiYue
	 * @date 2019年4月25日,上午9:57:02
	 * @return
	 */
	public String getQRCodeById_or(String ids) {
		String sqlParam = " select org.CODE as orgcode,pat.code as patCode,en.code as entpCode from ci_order ord " + 
				" left JOIN BD_ORG org on org.id_org = ord.id_org " + 
				" left join pi_pat pat on pat.id_pat = ord.id_pat " + 
				" left join en_ent en on en.id_ent = ord.id_en " + 
				" where id_or in("+ids+") ";
		 String QRcode ;
		try {
			QRCodeParamDTO result	= CiorderPrintUtils.GetQueryBeanResulte(QRCodeParamDTO.class, sqlParam);
			QRCodeFactory codeFact = new QRCodeFactory();
			QRcode = codeFact.creatQRCode(result);
		} catch (Exception e) {
			return " ";
		}
		return QRcode;
	}
	/**
	 * id_en获取二维码
	 * @code 
	 * @author LiYue
	 * @date 2019年4月25日,上午9:57:02
	 * @return
	 */
	public String getQRCodeById_en(String id_en) {
 		String sqlParam = " select org.CODE as orgcode,pat.code as patCode,en.code as entpCode from en_ent en" + 
				" left JOIN BD_ORG org on org.id_org = en.id_org " + 
				" left join pi_pat pat on pat.id_pat = en.id_pat " + 
				" left join ci_order ord   on en.id_ent = ord.id_en " + 
				" where en.id_ent = '"+id_en+"' ";
		 String QRcode ;
		try {
			QRCodeParamDTO result	= CiorderPrintUtils.GetQueryBeanResulte(QRCodeParamDTO.class, sqlParam);
			QRCodeFactory codeFact = new QRCodeFactory();
			QRcode = codeFact.creatQRCode(result);
		} catch (Exception e) {
			return " ";
		}
		return QRcode;
	}
	/**
	 * 执行查询
	 * @param ids
	 * @param blstatetp
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<HeadDTO> exec(String ids, String blstatetp) throws Exception{
		if (StringUtils.isNullOrEmpty(ids))
			return null;
		this.Bl_State = blstatetp;
		return this.exec(ids);
	}

	/**
	 * 
	 */
	@Override
	public String getOrdInfoSqlQry(String ids) {
		return "";
	}

	/**
	 * 获取检验、检查、诊疗医嘱信息
	 */
	@Override
	public List<HeadDTO> getOrderList(String sqlQry) throws Exception {
		List<HeadDTO> result = CiorderPrintUtils.GetQueryResulte(HeadDTO.class, sqlQry);

		return result;
	}

	/**
	 * 
	 */
	@Override
	public String getItmInfoSqlQry(String id) {
		return "";
	}
	
	@Override
	public List<ItemDTO> getItemList(String sqlQry) throws Exception {
		List<ItemDTO> result = CiorderPrintUtils.GetQueryResulte(ItemDTO.class, sqlQry);
		
		return result;
	}

	/**
	 * 
	 */
	@Override
	public void setOrdInfo(List<HeadDTO> dtos) throws Exception {

		for (HeadDTO dto : dtos) {
			// 设置年龄（格式）
			if (dto.getDt_birth() != null) {
				Date birth = new Date();
				birth = CiorderPrintUtils.ConvertStrToDate(dto.getDt_birth());
				FDate dt = new FDate(birth);
				dto.setAge(AgeCalcUtil.getAge(dt));
			}
			// 设置过敏史
			if (dto.getId_pati() != null) {
				String des_alcla = CiorderPrintUtils.GetPatalcla(dto.getId_pati());
				dto.setDes_alcla(des_alcla);
			}
			// 设置开立日期（格式）
			if (dto.getDt_entry() != null) {
				Date dt_start = new Date();
				dt_start = CiorderPrintUtils.ConvertStrToDate(dto.getDt_entry());
				FDate fdt_start = new FDate(dt_start);
				dto.setDt_entry(fdt_start.toString());
			}
			// 打印日期（格式）
			Date dt_print = new Date();
			FDate fdt_print = new FDate(dt_print);
			dto.setDt_print(fdt_print.toString());
			//过敏史
			CiOrderPrintDiagService diag = new CiOrderPrintDiagService();
			dto.setStr_name_di(diag.exec(dto.getId_en()));
		}
	}
}
