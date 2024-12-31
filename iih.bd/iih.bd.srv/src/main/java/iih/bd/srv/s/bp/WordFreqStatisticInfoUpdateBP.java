package iih.bd.srv.s.bp;

import java.util.Hashtable;

import iih.bd.srv.oth.d.BizCntDTO;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.oth.d.desc.MedSrvWordFreqDODesc;
import iih.bd.srv.pub.BdSrvAppUtils;
import iih.bd.srv.pub.BdSrvUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 词频使用统计信息更新操作BP
 */
public class WordFreqStatisticInfoUpdateBP {
	/**
	 * 词频使用统计信息更新操作BP
	 * @param wfpkdata   词频统计索引主键及其对应的值
	 * @param bizcnts    词频本次业务使用情况数据
	 * @throws BizException
	 */
	public void exec(MedSrvWordFreqDO wfpkdata,BizCntDTO[] bizcnts) throws BizException{
		//有效性校验
		if(BdSrvUtils.isEmpty(bizcnts))return;
		
		//获得对应已统计的词频使用情况
		String whereStr=getWhereStr(wfpkdata,bizcnts);
		String orderStr="";
		MedSrvWordFreqDO[] wfdos=BdSrvAppUtils.getSrvwordfreqQryService().find(whereStr, orderStr, FBoolean.FALSE);
		//if(BdSrvUtils.isEmpty(wfdos))return;
		
		//词频统计数据创建更新保存
		wfInfoSave(wfpkdata,wfdos);
	}
	
	/**
	 * 词频统计数据创建更新保存
	 * @param wfpkdata
	 * @param wfdos
	 * @throws BizException
	 */
	private void wfInfoSave(MedSrvWordFreqDO wfpkdata,MedSrvWordFreqDO[] wfdos) throws BizException{
		WordFreqInfoSaveBP bp=new WordFreqInfoSaveBP();
		bp.exec(wfpkdata, ht, wfdos);
	}
	
	/**
	 * 获得查询词频的条件sql片段串
	 * @param wfpkdata
	 * @param bizcnts
	 * @return
	 */
	private String getWhereStr(MedSrvWordFreqDO wfpkdata,BizCntDTO[] bizcnts){
		String rtn="";
		String bizidstr=getBizIDStr(bizcnts);
		String tblalis=MedSrvWordFreqDODesc.TABLE_ALIAS_NAME;
		rtn=tblalis+BdSrvUtils.DOT_STR+MedSrvWordFreqDO.ID_BIZ+BdSrvUtils.getCondStrWithEqualOrIn(bizidstr);
		String pkeystr=getPKeyCondStr(wfpkdata,tblalis);
		if(BdSrvUtils.isEmpty(pkeystr))return rtn;
		return pkeystr +rtn;
	}
	
	/**
	 * 获得基本服务查询索引主键的条件约束字符串
	 * @param wfpkdata
	 * @param tblalis
	 * @return
	 */
	private String getPKeyCondStr(MedSrvWordFreqDO wfpkdata,String tblalis){
		String rtn="";
		//有效性判断
		if(wfpkdata==null)return null;
		
		//词频主键标识
		if(!BdSrvUtils.isEmpty(wfpkdata.getId_wordfreq())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.ID_WORDFREQ,wfpkdata.getId_wordfreq())+BdSrvUtils.AND_STR;
		}
		
		//所属集团标识
		if(!BdSrvUtils.isEmpty(wfpkdata.getId_grp())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.ID_GRP,wfpkdata.getId_grp())+BdSrvUtils.AND_STR;
		}
		
		//所属组织标识
		if(!BdSrvUtils.isEmpty(wfpkdata.getId_org())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.ID_ORG,wfpkdata.getId_org())+BdSrvUtils.AND_STR;
		}
		
		//部门标识
		if(!BdSrvUtils.isEmpty(wfpkdata.getId_dept())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.ID_DEPT,wfpkdata.getId_dept())+BdSrvUtils.AND_STR;
		}
		
		//人员标识
		if(!BdSrvUtils.isEmpty(wfpkdata.getId_emp())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.ID_EMP,wfpkdata.getId_emp())+BdSrvUtils.AND_STR;
		}
		
		//业务类型
		if(!BdSrvUtils.isEmpty(wfpkdata.getBiz_classtype())){
			rtn+=getPKeyCondStr(tblalis,MedSrvWordFreqDO.BIZ_CLASSTYPE,wfpkdata.getBiz_classtype())+BdSrvUtils.AND_STR;
		}
		
		return rtn;
	}
	
	/**
	 * 获得基本服务查询索引主键的基本条件约束字串
	 * @param tblalis
	 * @param fldname
	 * @param fldvalue
	 * @return
	 */
	private String getPKeyCondStr(String tblalis,String fldname,String fldvalue){
		return tblalis+BdSrvUtils.DOT_STR+fldname+BdSrvUtils.EQUAL_STR+BdSrvUtils.SQUOTE_MARK_STR+fldvalue+BdSrvUtils.SQUOTE_MARK_STR;
	}
	
	private Hashtable ht;//词频使用bizid的个数key-value对
	/**
	 * 获得词频统计对应业务主键值连接字串
	 * @param bizcnts
	 * @return
	 */
	private String getBizIDStr(BizCntDTO[] bizcnts){
		String rtnStr="";
		ht=new Hashtable();
		for(int i=0;i<bizcnts.length;i++){
			ht.put(bizcnts[i].getId_biz(), bizcnts[i].getCnt());
			rtnStr+=BdSrvUtils.getSqlCondStrWithComma(bizcnts[i].getId_biz());
		}
		return rtnStr.substring(1);
	}
}
