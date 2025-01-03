/*
 * 健康评估维护服务
 * 
 * 
 */
package iih.pe.phm.i;

import iih.pe.papt.dto.pehmapptdto.d.PeHmApptDTO;
import iih.pe.phm.pedietplan.d.PedietplanAggDO;
import iih.pe.phm.pegencond.d.PeGenCondDO;
import iih.pe.phm.pehmgroup.d.PeHmGroupDO;
import iih.pe.phm.pehmgroup.d.PeHmGroupPsnDO;
import iih.pe.phm.pekinematics.d.PeKinematicsDO;
import xap.mw.core.data.BizException;

public interface IPeHmEvalGenMaintainService{
	
    /*
     * 
     * 一般健康状况评估
     * 2020-03-05, nielisheng
     */
	PeGenCondDO evalGen(PeHmApptDTO hmappt, PeGenCondDO gen) throws BizException;	
	
	/**
	 * 缺血性冠心病评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void evalIcvd(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 糖尿病评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void evalDiabetes(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 脑卒中评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void evalStroke(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 健康问卷摘要汇总
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void suvDigestSummary(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 生活方式评估评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void lifestyleAssess(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 营养评估评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void nutritionAssess(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 运动评估评估
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void kinematicsAssess(PeKinematicsDO peKinematicsDO) throws BizException;
	
	/**
	 * 营养处方生成饮食计划
	 * @param peHmApptDTO
	 * @param pedietplanAggDO
	 * @throws BizException
	 */
	PedietplanAggDO[] generateDietplan(PedietplanAggDO pedietplanAggDO, PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 数据汇集
	 * @param peHmApptDTO
	 * @throws BizException
	 */
	void dataAggregate(PeHmApptDTO peHmApptDTO) throws BizException;
	
	/**
	 * 群体健康管理节点_检索按钮
	 * @param peHmGroupDO
	 * @throws BizException
	 */
	void groupSearch(PeHmGroupDO peHmGroupDO) throws BizException;
} 
