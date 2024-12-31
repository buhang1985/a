package iih.pe.papi.i.lis;

import iih.mp.nr.dto.mergedsamppridto.d.MergedSamppriDTO;
import iih.mp.nr.labelprint.d.LabelDTO;
import iih.mp.nr.labelprint.d.LabelParamDTO;
import iih.mp.nr.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IPeButtLisService {

	/*
	 * 获取检验结果
	 * 
	 */
	public abstract Boolean pePatientConnectLis (String id_pepsnappt, String fg_aggin, String fg_continue) throws BizException;

	/**
	 * 获取标本集合
	 * 
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public abstract LabelDTO[] getLabelDTOList(LabelParamDTO paramdto) throws BizException;

	/**
	 * 标签打印保存
	 * 
	 * @param printedLabelDTOS
	 * @return
	 * @throws BizException
	 */
	public abstract LabelDTO[] labelSave(LabelDTO[] printedLabelDTOS, String Sd_srvtp) throws BizException;

	/**
	 * 体检检验标本合管
	 * 
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public abstract boolean sampleMergeTubes(String id_pepsnappt,String multiGroupValue, FBoolean forceNew) throws BizException;

	/**
	 * 合管后的标本费用对照
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract MergedSamppriDTO[] mergedSamppri(String[] id_ors, String id_pepsnappt) throws BizException;
}
