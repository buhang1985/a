package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.DiInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
/**
 * 
* @ClassName: GetDiInfoBp
* @Description: 获取诊断数据
* @author zhy
* @date 2019年9月25日
*
 */
public class GetDiInfoBp extends IIHServiceBaseBP<BaseParamDTO, DiInfoResultDTO>{
	
	/**
	 * 入参校验
	 */
	@Override
	protected void checkParam(BaseParamDTO param) throws BizException {
		if (null == param.getPageinfo() || param.getPageinfo().size() < 1) {
			throw new BizException("未传入分页信息");
		}
		
	}
	
	/**
	 * 核心业务
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected DiInfoResultDTO process(BaseParamDTO param) throws BizException {
		DiInfoResultDTO resultDTO = new DiInfoResultDTO();
		DiInfoSql sql = new DiInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<DiInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), DiInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setDiinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,DiInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}

}
