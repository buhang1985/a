package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 
 * @author 候诊队列帮助BP
 *
 */
public class WaitQueSortUtilBP {
	/**
	 * 根据初回比例排序
	 * 
	 * @param first 初诊数据
	 * @param rtn 回诊数据
	 * 
	 * @param siteInfo 站点信息
	 * @param hasMaxNum 是否有最大返回数量
	 * @return
	 * @throws BizException
	 */
	public <T> List<T> sort(List<T> first, List<T> rtn, EnTrDocSiteInfoDTO siteInfo, boolean hasMaxNum) throws BizException{
		int ratioFirst = 1;
		int ratioReturn = 1;
		int firstNum = 0;
		int returnNum = 0;
		Integer maxNeedNum = null;
		
		//对初回比例赋值
		BdQueEP bdQueEP = new BdQueEP();
		QueDO que = bdQueEP.getQueById((String)siteInfo.getId_ques().get(0));
		if (!EnValidator.isEmpty(que)) {
			if(que.getRatio_first() != null && que.getRatio_first() > 0){
				ratioFirst = que.getRatio_first();
			}
			if(que.getRatio_rtn() != null && que.getRatio_rtn() > 0){
				ratioReturn = que.getRatio_rtn();
			}
		}
		//对最大上屏数量赋值
		if(hasMaxNum){
			BdSiteEP siteEP = new BdSiteEP();
			QueSiteDO site = siteEP.getSiteById(siteInfo.getId_quesite());
			if (!EnValidator.isEmpty(site)) {
				maxNeedNum = site.getCall_num();
			}
		}
		List<ReceptionQueDTO> hasSortList = this.getSortList(ratioFirst, ratioReturn, siteInfo);
		if(!EnValidator.isEmpty(hasSortList)) {
			int f = 0;
			int r = 0;
			for(ReceptionQueDTO rect : hasSortList) {
				if(FBoolean.TRUE.equals(rect.getFg_needrtn())){
					if(f > 0)
						break;
					r++;
					continue;
				}
				if(r > 0)
					break;
				f++;
			}
			if(f > 0){
				firstNum = ratioFirst - f;
				returnNum = ratioReturn;
			}
			if(r > 0){
				returnNum = ratioReturn - r;
			}
		}
		return this.sort(first, rtn, ratioFirst, ratioReturn, firstNum, returnNum, maxNeedNum);
	}
	/**
	 * 候诊按初回比例排序
	 * 
	 * 
	 * @param first 初诊数据
	 * @param rtn 回诊数据
	 * @param ratioFirst 初回比例_初诊
	 * @param ratioReturn 初回比例_回诊
	 * @param firstNum 队列开始时需要初诊数据
	 * @param returnNum 队列开始时需要的回诊数据
	 * @param maxNeedNum 
	 * 		返回最大数据量（如果为空或小于0，返回全部）
	 * @return
	 */
	public <T> List<T> sort(List<T> first, List<T> rtn, int ratioFirst, int ratioReturn, int firstNum, int returnNum, Integer maxNeedNum){
		List<T> list = new LinkedList<>();
		//判断初诊队列和回诊队列是否为空
		if(EnValidator.isEmpty(first) || EnValidator.isEmpty(rtn)){
			if(EnValidator.isEmpty(first)){
				list.addAll(rtn);
			}else if(EnValidator.isEmpty(rtn)){
				list.addAll(first);
			}
			return this.subList(list, maxNeedNum);
		}
		//开始需要添加多少初诊数据
		while(firstNum > 0) {
			if(EnValidator.isEmpty(first))
				break;
			list.add(first.remove(0));
			firstNum--;
		}
		//开始需要添加多少初诊数据
		while(returnNum > 0) {
			if(EnValidator.isEmpty(rtn))
				break;
			list.add(rtn.remove(0));
			returnNum--;
		}
		while(!EnValidator.isEmpty(first) || !EnValidator.isEmpty(rtn)){
			int ratio = ratioFirst;
			while(ratio > 0){
				if(EnValidator.isEmpty(first))
					break;
				list.add(first.remove(0));
				ratio--;
			}
			ratio = ratioReturn;
			while(ratio > 0){
				if(EnValidator.isEmpty(rtn))
					break;
				list.add(rtn.remove(0));
				ratio--;
			}
		}
		return this.subList(list, maxNeedNum);//TODO:后续优化一下
	}
	/**
	 * 获取list的前maxNeedNum个对象
	 * 
	 * @param list
	 * @param maxNeedNum
	 * @return
	 */
	private <T> List<T> subList(List<T> list, Integer maxNeedNum){
		if(!EnValidator.isEmpty(list)){
			if((maxNeedNum == null ? 0 : maxNeedNum) > 0 && list.size() > maxNeedNum) {
				list = list.subList(0, maxNeedNum);
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 获取已排序队列信息
	 * 
	 * @throws BizException
	 */
	private List<ReceptionQueDTO> getSortList(int ratioFirst, int ratioReturn, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		List<String> list = new ArrayList<String>();
		for(Object obj : siteInfo.getId_ques())
			list.add((String)obj);
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT TOP ").append(ratioFirst + ratioReturn);
		builder.append(" EN.ID_ENT AS ID_ENT,");
		builder.append("EN.ID_PAT AS ID_PAT,");
		builder.append("EN.NAME_PAT AS NAME_PAT,");
		builder.append("EQ.ID_ENT_QUE AS ID_ENT_QUE,");
	    builder.append("EQ.SD_STATUS_ACPT AS SD_STATUS_ACPT,"); 
	    builder.append("EQ.SORTNO AS TICKETNO,");
	    builder.append("EQ.SORTNO_CALLED AS SORTNO_CALLED,");
	    builder.append("OP.FG_NEEDRTN AS FG_NEEDRTN,"); 
	    builder.append("OP.SD_STATUS AS SD_STATUS "); 
	    builder.append("FROM EN_ENT EN ");
	    builder.append("INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
	    builder.append("INNER JOIN EN_ENT_QUE EQ ON EN.ID_ENT = EQ.ID_ENT ");
	    builder.append("WHERE EQ.SD_ENTQUE_TP = ? ");
	    builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.ID_QUE_SITE = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.SD_STATUS_ACPT NOT IN (?, ?) ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.SORTNO_CALLED > 0 ");
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(siteInfo.getId_quesite());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED);
		param.addParam(siteInfo.getDate());
		builder.append(EnSqlUtils.getInSqlByIds("AND EQ.ID_QUE", list.toArray(new String[0])));
		builder.append("ORDER BY EQ.SORTNO_CALLED DESC ");
		String sql = builder.toString();
		Logger.info(sql);
		return (List<ReceptionQueDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ReceptionQueDTO.class));
	}
	/**
	 * 计算队列开始时需要的回诊数据
	 * 
	 * @param list 已排序队列信息
	 * @param ratioFirst 初回比例_初诊
	 * @param ratioReturn 初回比例_回诊
	 * @param firstNum 队列开始时需要初诊数据
	 * @param returnNum 队列开始时需要的回诊数据
	 */
	private void initFirstAndRtnNum(List<ReceptionQueDTO> list, int ratioFirst, int ratioReturn, int firstNum, int returnNum){
		if(EnValidator.isEmpty(list))
			return;
		int f = 0;
		int r = 0;
		
		for(ReceptionQueDTO rect : list) {
			if(FBoolean.TRUE.equals(rect.getFg_needrtn())){
				if(f > 0)
					break;
				r++;
				continue;
			}
			if(r > 0)
				break;
			f++;
		}
		if(f > 0)
			firstNum = ratioFirst - f;
		if(r > 0)
			returnNum = ratioReturn - f;
	}
}
