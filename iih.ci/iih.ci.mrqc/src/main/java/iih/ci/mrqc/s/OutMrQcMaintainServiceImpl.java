/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s;

import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import iih.ci.mrqc.i.IOutMrQcMaintainService;
import iih.ci.mrqc.mrqcerrordto.d.MrQcErrorDTO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import iih.ci.mrqc.s.bp.outqc.OutMrQcPageInfoQryBP;
import iih.ci.mrqc.s.bp.outqc.OutMrQcQryBP;
import iih.ci.mrqc.s.bp.outqc.OutMrQcRandomRulePageInfoQryBP;
import iih.ci.mrqc.s.bp.outqc.OutMrQcSaveBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 〈扼要描述〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
@Service(serviceInterfaces = { IOutMrQcMaintainService.class }, binding = Binding.JSONRPC)
public class OutMrQcMaintainServiceImpl implements IOutMrQcMaintainService{
		/**
		 * 门诊部 根据规则设置 产生各个科室的抽查数据
		 * @param ruleDos
		 * @return
		 * @throws BizException
		 */
		@Override
		public MrQcErrorDTO[] OpdInsertRandomRecordByRule(CiMrQcRandomRuleDO[] ruleDos)
				throws BizException {
			OutMrQcSaveBP saveBp=new OutMrQcSaveBP();
			return saveBp.OpdInsertRandomRecordByRule(ruleDos);
		}
		/**
		 * 批量修改门诊部抽查规则
		 * @param ruleDos
		 * @return
		 * @throws BizException
		 */
		@Override
		public FBoolean MultiChangeRule(CiMrQcRandomRuleDO[] ruleDos, CiMrQcRandomRuleDO changeDo)
				throws BizException {
			OutMrQcSaveBP saveBp=new OutMrQcSaveBP();
			return saveBp.MultiChangeRule(ruleDos,changeDo);
		}
		/**
		 * 门诊科室质控完成质控操作
		 * @param score
		 * @param patDto
		 * @return
		 * @throws BizException
		 */
		@Override
		public FBoolean CompleteDepOutQc(String score, MrQcRandomItmDTO patDto)
				throws BizException {
			OutMrQcSaveBP saveBp=new OutMrQcSaveBP();
			return saveBp.CompleteDepOutQc(score,patDto);
		}
		/**
		 * 门诊部质控完成质控操作
		 * @param score
		 * @param patDto
		 * @return
		 * @throws BizException
		 */
		@Override
		public FBoolean CompleteOpdOutQc(String score, MrQcRandomItmDTO patDto)
				throws BizException {
			OutMrQcSaveBP saveBp=new OutMrQcSaveBP();
			return saveBp.CompleteOpdOutQc(score,patDto);
		}
		/**
		 * 根据门诊质控类型获取对应的缺陷
		 * @param id_ent
		 * @param id_qc_type
		 * @return
		 * @throws BizException
		 */
		@Override
		public QaFltDTO[] getOutQcfltDtosByQcType(String id_ent,String id_qc_type) throws BizException {
			OutMrQcQryBP qryBp=new OutMrQcQryBP();
			return qryBp.getOutQcfltDtosByQcType(id_ent,id_qc_type);
		}
		/**
		 * 获取门诊科室质控抽查记录明细
		 * @param id_random
		 * @return
		 * @throws BizException
		 */
		@Override
		public MrQcRandomItmDTO[] getOutDepMrQcRandomItmDtos(String id_random)
				throws BizException {
			OutMrQcQryBP qryBp=new OutMrQcQryBP();
			return qryBp.getOutDepMrQcRandomItmDtos(id_random);
		}
		/**
		 * 门诊科室已抽查查询记录主表
		 * @param qryRootNodeDTO
		 * @param paginationInfo
		 * @return
		 * @throws BizException
		 */
		@Override
		public PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordDoList(
				QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
				throws BizException {
			OutMrQcPageInfoQryBP pageBp=new OutMrQcPageInfoQryBP();
			return pageBp.getOutDepQcHasRandomRecordDoList(qryRootNodeDTO, paginationInfo);
		}
		/**
		 * 门诊科室质控记录查询记录主表
		 * @param qryRootNodeDTO
		 * @param paginationInfo
		 * @return
		 * @throws BizException
		 */
		@Override
		public PagingRtnData<CiMrQcRandomRecordDO> getOutDepQcHasRandomRecordQryList(
				QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
				throws BizException {
			OutMrQcPageInfoQryBP pageBp=new OutMrQcPageInfoQryBP();
			return pageBp.getOutDepQcHasRandomRecordQryList(qryRootNodeDTO, paginationInfo);
		}
		/**
		 * 门诊部已抽查查询记录主表
		 * @param qryRootNodeDTO
		 * @param paginationInfo
		 * @return
		 * @throws BizException
		 */
		@Override
		public PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordDoList(
				QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
				throws BizException {
			OutMrQcPageInfoQryBP pageBp=new OutMrQcPageInfoQryBP();
			return pageBp.getOutOpdQcHasRandomRecordDoList(qryRootNodeDTO, paginationInfo);
		}
		/**
		 * 门诊部质控记录查询记录主表
		 * @param qryRootNodeDTO
		 * @param paginationInfo
		 * @return
		 * @throws BizException
		 */
		@Override
		public PagingRtnData<CiMrQcRandomRecordDO> getOutOpdQcHasRandomRecordQryList(
				QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
				throws BizException {
			OutMrQcPageInfoQryBP pageBp=new OutMrQcPageInfoQryBP();
			return pageBp.getOutOpdQcHasRandomRecordQryList(qryRootNodeDTO, paginationInfo);
		}
		/**
		 * 门诊部抽查规则-查询
		 * @param qryRootNodeDTO
		 * @param paginationInfo
		 * @return
		 * @throws BizException
		 */
		@Override
		public PagingRtnData<CiMrQcRandomRuleDO> getOutMrQcRandomRuleQryList(
				QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
				throws BizException {
			OutMrQcRandomRulePageInfoQryBP pageBp=new OutMrQcRandomRulePageInfoQryBP();
			return pageBp.getOutMrQcRandomRuleQryList(qryRootNodeDTO, paginationInfo);
		}
}
