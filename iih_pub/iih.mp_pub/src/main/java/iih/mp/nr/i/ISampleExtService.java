package iih.mp.nr.i;

import iih.mp.nr.dto.mergedsamppridto.d.MergedSamppriDTO;
import iih.mp.nr.labelprint.d.LabelDTO;
import iih.mp.nr.labelprint.d.LabelParamDTO;
import iih.mp.nr.labelprint.d.SampleInfusionDTO;
import iih.mp.nr.labelprint.d.TestSampleDTO;
import iih.mp.nr.mpwardprint.d.WardPrntCondDTO;
import xap.mw.core.data.BizException;

public interface ISampleExtService {

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
	 * 住院检验标本合管
	 * 
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public abstract void sampleMergeTubes(WardPrntCondDTO paramCond, String id_ents) throws BizException;
	
	/**
	 * 合管后的标本费用对照
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract MergedSamppriDTO[] mergedSamppri(String[] id_ors) throws BizException;
}
