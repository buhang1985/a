package iih.ei.std.s.v1.bp.mp.basedata;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.NoParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.BaseParamDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.DiInfoResultDTO;
import iih.ei.std.d.v1.mp.basedata.d.FeetypeInfoDTO;
import iih.ei.std.d.v1.mp.basedata.d.FeetypeInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.mp.basedata.qry.FeetypeInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
* @ClassName: GetFeetypeInfoBp
* @Description: 获取费别基础数据
* @author zhy
* @date 2019年9月24日
*
 */
@SuppressWarnings("unchecked")
public class GetFeetypeInfoBp extends IIHServiceBaseBP<BaseParamDTO, FeetypeInfoResultDTO> {
	
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
	@Override
	protected FeetypeInfoResultDTO process(BaseParamDTO param) throws BizException {
		FeetypeInfoResultDTO resultDTO = new FeetypeInfoResultDTO();
		FeetypeInfoSql sql = new FeetypeInfoSql();
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<FeetypeInfoDTO> findPagingData = findPagingData(pageInfoDto, sql.getQrySQLStr(), sql.getQryParameter(null), FeetypeInfoDTO.class);
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setFeetypeinfo(ArrayListUtil.ConvertToFArrayList(findPagingData));
		return resultDTO;
	}

	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,FeetypeInfoResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}

}
