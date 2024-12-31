package iih.ei.std.s.v1.bp.ci.thirdws.operation;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ei.std.d.v1.ci.cancel.d.EmsCancelOrdDTO;
import iih.ei.std.d.v1.ci.cancel.d.EntWsCancelDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @code 第三方作废BP @author LiYue
 */
public class EmsOrdCancelBP extends IIHServiceBaseBP<EntWsCancelDTO, ResultDTO> {

	// 入参校验
	@SuppressWarnings("unchecked")
	protected void checkParam(EntWsCancelDTO entWsDTO) throws BizException {
		if (entWsDTO == null) {
			throw new BizException("就诊信息为空！");
		} else {
			if (StringUtils.isEmpty(entWsDTO.getCode_org())) {

				throw new BizException("就诊信息中的所属组织不能为空\n");
			}
			if (StringUtils.isEmpty(entWsDTO.getCode_pat())) {

				throw new BizException("就诊信息中的患者编码不能为空\n");
			}
			if (StringUtils.isEmpty(entWsDTO.getCode_entp())) {

				throw new BizException("就诊信息中的就诊类型编码不能为空\n");
			}
			List<EmsCancelOrdDTO> emsCancelOrdDTO = (List<EmsCancelOrdDTO>) entWsDTO.getEmscancelorddto();
			if (emsCancelOrdDTO == null) {
				throw new BizException("作废信息为空！");
			} else {
				int i = 0;
				for (EmsCancelOrdDTO cancelOrdDTO : emsCancelOrdDTO) {
					i++;
					if (StringUtils.isEmpty(cancelOrdDTO.getCode_or())) {

						throw new BizException("第" + i + "个作废信息中的医嘱编码不能为空\n");
					}
					if (StringUtils.isEmpty(cancelOrdDTO.getCode_emp_canc())) {

						throw new BizException("第" + i + "个作废信息中的作废医生不能为空\n");
					}
					if (StringUtils.isEmpty(cancelOrdDTO.getCode_dep_canc())) {

						throw new BizException("第" + i + "个作废信息中的作废科室不能为空\n");
					}
					if (StringUtils.isEmpty(cancelOrdDTO.getDt_canc())) {

						throw new BizException("第" + i + "个作废信息中的作废操作时间不能为空\n");
					}
					if (StringUtils.isEmpty(cancelOrdDTO.getEu_actiontp())) {

						throw new BizException("第" + i + "个作废信息中的操作类型不能为空\n");
					}
				}
			}
		}
	}

	// 作废处理
	protected ResultDTO process(EntWsCancelDTO entWsDTO) throws BizException {
		ResultDTO resultDTO = new ResultDTO();
		List<EmsCancelOrdDTO> emsCancelOrdDTO = (List<EmsCancelOrdDTO>) entWsDTO.getEmscancelorddto();
		String id_ors = "";
		for (EmsCancelOrdDTO emsCancelOrdDTO2 : emsCancelOrdDTO) {
			String Code_or = (String) emsCancelOrdDTO2.getAttrVal("Code_or");
			id_ors = id_ors + Code_or + ",";
		}
		id_ors = id_ors.substring(0, id_ors.length() - 1);
		ICiorderMDORService srv = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] orsDOs = srv.findByAttrValStrings(CiOrderDO.CODE_OR, id_ors.split(","));
		FArrayList fList = new FArrayList();
		FMap2 map = new FMap2();
		if (orsDOs != null) {
			for (CiOrderDO ciOrderDO : orsDOs) {
				fList.add(ciOrderDO.getAttrVal("Id_or"));
				map.put((String) ciOrderDO.getAttrVal("Id_or"), ciOrderDO.getAttrVal("Sd_su_or"));
			}
			// 调用作废医嘱
			OrderOperateDTO orderOperateDTO = new OrderOperateDTO();
			CiEnContextDTO ctx = new CiEnContextDTO();
			ctx.setAttrVal("Id_grp", entWsDTO.getAttrVal("Code_grp"));
			ctx.setAttrVal("Id_org", entWsDTO.getAttrVal("code_org"));
			ctx.setAttrVal("Id_pat", entWsDTO.getAttrVal("code_pat"));
			ctx.setAttrVal("Id_en", entWsDTO.getAttrVal("code_en"));
			ctx.setAttrVal("Id_entp", entWsDTO.getAttrVal("code_entp"));
			orderOperateDTO.setAttrVal("Extension", map);
			orderOperateDTO.setAttrVal("Document", fList);
			ServiceFinder.find(ICiOpOrderMainService.class).cancel(ctx, orderOperateDTO);
			resultDTO.setResultcode("0");
			resultDTO.setResultmsg("成功！");
		} else {
			resultDTO.setResultcode("1");
			resultDTO.setResultmsg("作废医嘱不存在！");
		}
		return resultDTO;
	}

}
