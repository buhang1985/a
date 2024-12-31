package iih.en.que.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ScripRulConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.board.d.BrdtpEnum;
import iih.en.que.board.d.EnBrdDO;
import iih.en.que.board.d.EnBrdSiteDO;
import iih.en.que.board.i.IEnbrddoMDORService;
import iih.en.que.dto.d.AllQue4EsDTO;
import iih.en.que.s.bp.GetBrdNameRulScripBP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 通过大屏地址获取需要上屏的患者队列
 * @author fanlq
 *
 */
public class GetDrugQueByAddrBP {
/***
 * 通过大屏地址获取需要上屏的患者队列
 * @param addr_brd
 * @return
 * @throws BizException
 */
	public EnBrdSiteDO[] exec(String addr_brd) throws BizException{
		FDate curTime = getcurDate();
		String nos_arrived = this.setArrivedPatinfos(addr_brd);
		List<EnBrdSiteDO> brdlist = new ArrayList<EnBrdSiteDO>();
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct pat.id_pat,pat.code as code_pat,sit.code as Code_quesite, que.name_pat as Name_pat,que.sortno as Tickno,sit.addr_board as Addr_board_site,que.sd_status_acpt, que.dt_regist  ");
		builder.append("from en_ent_que que ");
		builder.append("left join bd_que_site sit on sit.id_quesite = que.id_que_site ");
		builder.append("inner join pi_pat pat on pat.id_pat = que.id_pat ");
		builder.append("where 1=1 ");
		builder.append("and que.dt_regist = ? ");
		builder.append("and sit.fg_active = ? ");
		builder.append("and sit.addr_board = ? ");	
		SqlParam param = new SqlParam();
		param.addParam(curTime);
		param.addParam(FBoolean.TRUE);
		param.addParam(addr_brd);
		Integer brdType = this.getBrdType(addr_brd);
		if(brdType != null && BrdtpEnum.DRUGBRD.equals(brdType)){
			builder.append("and que.sd_entque_tp in (?,?) ");
			builder.append("and sit.sd_quesitetp in (?,?) ");
			builder.append("and que.sd_status_acpt in (?,?,?,?,?) ");
			param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
			param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
			param.addParam(IBdFcDictCodeConst.SD_QUESITETP_SENDM);
			param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);//签到
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE);//签到
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL);//叫号
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);//到诊
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);//叫号
		}else{
			builder.append("and que.sd_entque_tp = ? ");
			builder.append("and sit.sd_quesitetp = ? ");
			builder.append("and que.sd_status_acpt in (?,?) ");	
			param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
			param.addParam(IBdFcDictCodeConst.SD_QUESITETP_UNIVERSAL);		
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);//到诊
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);//叫号
		}
		builder.append("order by que.sortno, que.dt_regist asc");
		@SuppressWarnings("unchecked")
		List<AllQue4EsDTO> list = (List<AllQue4EsDTO>) new DAFacade().execQuery(builder.toString(), param, new BeanListHandler(AllQue4EsDTO.class));
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		if(list != null && list.size() > 0){
			for(AllQue4EsDTO es : list){
				EnBrdSiteDO brdSiteDO = new EnBrdSiteDO();
				int sortno = 0;
				sortno=getMaxSortno(es.getId_pat(),addr_brd);
				brdSiteDO.setAddr_brd(es.getAddr_board_site());
				brdSiteDO.setCode(es.getCode_quesite());
				//调用脚本设计器显示患者姓名
				String name_curpat = bp.exec(es.getName_pat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.CURPAT);
				brdSiteDO.setName_curpat(name_curpat);
				//brdSiteDO.setNo_curpat(es.getTickno());
				brdSiteDO.setNo_curpat(Integer.toString(sortno));
				brdSiteDO.setCode_pat(es.getCode_pat());
				brdSiteDO.setNos_arrived(nos_arrived);
				brdlist.add(brdSiteDO);
			}
			if(brdlist != null && brdlist.size() > 0){
				return brdlist.toArray(new EnBrdSiteDO[]{});
			}
		}
		return null;
	}
	/***
	 * 
	 * 获取大屏站点类型
	 * @param allQue4EsDTO
	 * @return
	 * @throws BizException
	 */
	private Integer getBrdType(String addr_brd) throws BizException{
		IEnbrddoMDORService service = ServiceFinder.find(IEnbrddoMDORService.class);
		EnBrdDO[] enBrdDOs = service.find("addr = '"+addr_brd+"'",null, FBoolean.FALSE);
		if(enBrdDOs != null && enBrdDOs.length > 0){
			EnBrdDO enBrdDO = enBrdDOs[0];
			return enBrdDO.getEu_brdtpc();
		}
		return null;
	}
	/***
	 * 获取一个患者票号的最大值
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private int getMaxSortno(String id_pat,String addr_brd) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select max(que.sortno) ");
		sql.append("from en_ent_que que " );
		sql.append("left join bd_que_site sit on sit.id_quesite = que.id_que_site " );
		sql.append("where que.id_pat= ? " );
		sql.append("and que.dt_in >= ? " );
		sql.append("and que.dt_in <= ? " );
		sql.append("and sit.addr_board = ? " );
		sql.append("group by que.id_pat ");
		SqlParam param = new SqlParam();
		param.addParam(id_pat);
		FDate curDate= getcurDate();
		param.addParam(curDate);
		param.addParam(curDate.getDateAfter(1));
		param.addParam(addr_brd);
		return (int) new DAFacade().execQuery(sql.toString(), param, new ColumnHandler());
	}
	
	private FDate getcurDate(){
		return EnAppUtils.getServerDate();
	}
	
	/**
	 * 获取未到诊患者信息，fanlq-2019-07-15
	 * @param brdSiteDO
	 * @param opQue4EsDTO
	 * @param disDTO
	 * @throws BizException
	 */
	private String setArrivedPatinfos(String addr_brd) throws BizException{
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select pat.code as Code_pat,pat.name as Name_curpat,ben.addr_board,ent.dt_insert from en_ent_que que ");
		sql.append("inner join en_ent ent on ent.id_ent = que.id_ent " );
		sql.append("inner join en_ent_op op on op.id_ent = ent.id_ent " );
		sql.append("inner join sc_sch sch on sch.id_sch = op.id_sch " );
		sql.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl " );
		sql.append("inner join pi_pat pat on pat.id_pat = ent.id_pat " );
		sql.append("inner join bd_que_ben ben on ben.id_queben = pl.id_queben " );
		sql.append("where 1=1 " );
		sql.append("and que.sd_status_acpt = ? " );
		sql.append("and ent.code_entp = ? " );
		sql.append("and ent.fg_canc = ? " );
		sql.append("and ben.addr_board = ? " );
		sql.append("and ent.dt_entry = ? ");
		sql.append("order by ent.dt_insert ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		param.addParam(FBoolean.FALSE);
		param.addParam(addr_brd);
		param.addParam(EnAppUtils.getServerDateTime().getDate() + " 00:00:00");
		List<EnBrdSiteDO> list = (List<EnBrdSiteDO>) new DAFacade()
				.execQuery(sql.toString(), param, new BeanListHandler(EnBrdSiteDO.class));
		List<String> nosArrivedList = new ArrayList<String>();
		FMap map = new FMap();
		GetBrdNameRulScripBP bp = new GetBrdNameRulScripBP();
		if(list != null && list.size() > 0){
			for(EnBrdSiteDO enbrd : list){
				if(!EnValidator.isEmpty(enbrd.getCode_pat()) && !EnValidator.isEmpty(enbrd.getName_curpat()) && !map.containsKey(enbrd.getCode_pat())){
					map.put(enbrd.getCode_pat(), enbrd.getName_curpat());
					String name_curpat = bp.exec(enbrd.getName_curpat(),ScripRulConst.BRD_DRUG_SHOW_NAME,ScripRulConst.ARRIVEDPAT);
					nosArrivedList.add(name_curpat);
				}
			}
		}
		if(nosArrivedList != null && nosArrivedList.size() > 0){
			String nosArrived = nosArrivedList.toString();
			if(!EnValidator.isEmpty(nosArrived)){
				nosArrived = nosArrived.replace("[", "").replace("]", "");
				return nosArrived;
			}
		}
		return null;
	}
	
}
