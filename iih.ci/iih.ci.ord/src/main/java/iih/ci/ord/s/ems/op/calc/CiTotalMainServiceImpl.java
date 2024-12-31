package iih.ci.ord.s.ems.op.calc;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.op.tools.ICalculateTotal;
import iih.ci.ord.i.op.tools.ICiTotalMainService;
import iih.ci.ord.i.op.tools.TotalParameterDTO;
import iih.ci.ord.s.ems.op.ems.calcpri.CalculateTotalBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 计算总量和总次数
 * 
 * @author li_zheng
 *
 */
public class CiTotalMainServiceImpl implements ICiTotalMainService {

	@Override
	public Integer getTotalTimes(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		ICalculateTotal bp = new CalculateTotalBP();
		return bp.getTotalTimes(CiEnContext, totalParameterDTO);
	}

	@Override
	public Integer getDaysAvalidate(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException {
		ICalculateTotal bp = new CalculateTotalBP();
		return bp.getDaysAvalidate(CiEnContext, totalParameterDTO);

	}

	@Override
	public FDouble getMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		ICalculateTotal bp = new CalculateTotalBP();
		return bp.getMMQuantum(CiEnContext, totalParameterDTO);
	}

	@Override
	public FDouble getUnMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		ICalculateTotal bp = new CalculateTotalBP();
		return bp.getUnMMQuantum(CiEnContext, totalParameterDTO);
	}

}
