package iih.ci.ord.s.ems.op.bloodbadreaction.bp;


import iih.ci.ord.bloodbadreaction.d.CiBloodAdverseReactionDO;
import iih.ci.ord.dto.bloodbadreaction.BloodFetchDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.op.bloodbadreaction.qry.GetBloodBadReactionDOQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 创建输血不良反应回报单初始数据
 * @author yzh
 *
 */
public class BloodBadReactionCreatBP {
	public CiBloodAdverseReactionDO exec(BloodFetchDTO bfdto) throws BizException{
		if (CiOrdUtils.isEmpty(bfdto)) return null;
		String id_or = bfdto.getId_or();
		ITransQry qry = new GetBloodBadReactionDOQry(id_or);
		//String sql = qry.getQrySQLStr();
		CiBloodAdverseReactionDO[] abdrdos =  (CiBloodAdverseReactionDO[])AppFwUtil.getDORstWithDao(qry, CiBloodAdverseReactionDO.class);
		if(CiOrdUtils.isEmpty(abdrdos)) return null;
		
		if((abdrdos[0].getPregnant() != null &&  abdrdos[0].getPregnant()  > 0 )|| (abdrdos[0].getBirth() != null && abdrdos[0].getBirth() >0)){
			abdrdos[0].setFg_pregnant(FBoolean.TRUE);
		}else{
			abdrdos[0].setFg_pregnant(FBoolean.FALSE);
		}
		if(abdrdos[0].getDt_birth() != null) abdrdos[0].setAge(AgeCalcUtil.getAge(new FDate(abdrdos[0].getDt_birth())));
		abdrdos[0].setReport_time(CiOrdAppUtils.getServerDateTime());
		abdrdos[0].setUse_id_or(id_or);
		abdrdos[0].setStatus(DOStatus.NEW);
		return abdrdos[0];
	}
}
