package iih.ci.event.ord.bps.sign.ip.logicbp;

import iih.ci.event.ord.bps.sign.ip.query.IpNsSignEntInfoQuery;
import iih.ci.event.ord.bps.sign.ip.query.IpNsSignOrdInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IENsOrDTO;
import iih.ci.ord.iemsg.d.IENsOrEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 住院签署 护理逻辑处理BS304
 * @author F
 *
 * @date 2019年8月28日下午3:54:43
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.logicbp.IpNsSignLogicDealWithBP
 */
public class IpNsSignLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台护理服务数据信息 该方法将医嘱信息合并 签署多条医嘱时 只发一条信息 这样集成平台服务分类就会出现问题 消息头填哪个？
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IENsOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		//查询并获得就诊及确认数据信息
		IENsOrEnDTO[] rtn=getIENsOrEnDTOs(firedto.getIdors());
		if(OrdEventUtil.isEmpty(rtn))return null;
		//查询并设置确认数据对应的  其它医嘱数据信息集合
		setCiNsOrCItms4Confirm(firedto.getIdors(),rtn[0]);
		//返回
		return rtn;
	}
	
	/**
	 * 查询并设置确认数据对应的  其它医嘱数据信息集合
	 * @param id_ors
	 * @param rtn
	 * @throws BizException
	 */
	private void setCiNsOrCItms4Confirm(String id_ors,IENsOrEnDTO rtn) throws BizException{
		IpNsSignOrdInfoQuery qry1=new IpNsSignOrdInfoQuery(id_ors);
		IENsOrDTO[] itms = (IENsOrDTO[])AppFwUtil.getDORstWithDao(qry1, IENsOrDTO.class);
		if(OrdEventUtil.isEmpty(itms))return;
		rtn.setId_iensors(OrdEventUtil.array2FArrayList2(itms));
	}
	
	
	/**
	 * 查询并获得就诊及确认数据信息
	 * @param id_ors
	 * @return
	 * @throws BizException 
	 */
	private IENsOrEnDTO[] getIENsOrEnDTOs(String id_ors) throws BizException{
		IpNsSignEntInfoQuery qry=new IpNsSignEntInfoQuery(getIdOr(id_ors));
		IENsOrEnDTO[] rtn = (IENsOrEnDTO[])AppFwUtil.getDORstWithDao(qry, IENsOrEnDTO.class);
		//設置值
		setValue(rtn);
		return rtn;
	}
	/**
	 * 设置值
	 * @param rtn
	 */
	private void setValue(IENsOrEnDTO[] rtn) {
		if(OrdEventUtil.isEmpty(rtn)) {
			return;
		}
		for(IENsOrEnDTO dto:rtn){
			//年龄
			if(!OrdEventUtil.isEmpty(dto.getBirthdaydate())) {
				dto.setAge(AgeCalcUtil.getAge(new FDate(dto.getBirthdaydate().toString())));
			}
			//就诊次数
			if(OrdEventUtil.isEmpty(dto.getAdmiss_times())) {
				dto.setAdmiss_times("0");
			}
			//就诊类别
			dto.setVisit_type_code(getParamCodeEntp(dto.getVisit_type_code()));
		}
	}
	
	/**
	 * 获得一个医嘱id
	 * @param id_ors
	 * @return
	 */
	private String getIdOr(String id_ors){
		return (id_ors.split(OrdEventUtil.COMMA_STR))[0];
	}
	/**
	 * 第二种逻辑处理，签署几条发几条消息
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public IENsOrEnDTO[] execOfNoMerge(OrdEventFireDTO firedto) throws BizException{
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		//查询所有就诊信息
		IpNsSignEntInfoQuery entQry=new IpNsSignEntInfoQuery(firedto.getIdors());
		IENsOrEnDTO[] rtn = (IENsOrEnDTO[])AppFwUtil.getDORstWithDao(entQry, IENsOrEnDTO.class);
		//查询所有医嘱信息
		IpNsSignOrdInfoQuery ordQry=new IpNsSignOrdInfoQuery(firedto.getIdors());
		IENsOrDTO[] itms = (IENsOrDTO[])AppFwUtil.getDORstWithDao(ordQry, IENsOrDTO.class);
		if(!OrdEventUtil.isEmpty(rtn)) {
			for(IENsOrEnDTO dto:rtn){
				//设置值
				setValue(rtn);
				//当 就诊信息的医嘱id 和 医嘱信息的医嘱id 一致时，将医嘱信息赋给就诊信息
				FArrayList2 fArrayList2=new FArrayList2();
				if(!OrdEventUtil.isEmpty(itms)) {
					for(IENsOrDTO ieNsOrDTO:itms){
						if(!OrdEventUtil.isEmpty(dto.getId_or())&&!OrdEventUtil.isEmpty(ieNsOrDTO.getId_iensor())&&
								dto.getId_or().equals(ieNsOrDTO.getId_iensor())) {
							fArrayList2.add(ieNsOrDTO);
						}
					}
					dto.setId_iensors(fArrayList2);
				}
			}
		}
		return rtn;
	}
}
