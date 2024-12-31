package iih.pi.patsrvpkg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pi.patsrvpkg.dto.PiPatSrvPkgGrpDTO;
import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import iih.pi.patsrvpkg.patsrvpkg.s.PatsrvpkgCrudServiceImpl;
import iih.pi.patsrvpkg.pipatsrvpkggr.d.PiPatSrvPkggrDO;
import iih.pi.patsrvpkg.pipatsrvpkggr.s.PipatsrvpkggrCrudServiceImpl;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PipatsrvpkgitemAggDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.s.PipatsrvpkgitemCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;


/**
 * 保存患者服务包及服务包分组
 * @author ly
 *
 */
public class SavePiPatSrvPkgBP {

	/**
	 * 保存患者服务包及服务包分组
	 * @param pkgs
	 * @return
	 * @throws BizException
	 */
	public PiPatSrvPkgTotalDTO[] exec(PiPatSrvPkgTotalDTO[] pkgs) throws BizException {
		
		if(pkgs == null)
			return null;
		
		for (PiPatSrvPkgTotalDTO pkgDto : pkgs) {
			this.savePkg(pkgDto);	
		}
		
		return pkgs;
	}
	
	/**
	 * 保存服务包
	 * @param pkgDto
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void savePkg(PiPatSrvPkgTotalDTO pkgDto) throws BizException {
		
		PatsrvpkgCrudServiceImpl pkgService = new PatsrvpkgCrudServiceImpl();
		PiPatSrvPkgDO newPkgDo = pkgService.insert(new PiPatSrvPkgDO[]{pkgDto.getPiPatSrvPkgDO()})[0];
	
		FArrayList newGrpList = new FArrayList();
		for (int i = 0; i < pkgDto.getGroup().size(); i++) {
			PiPatSrvPkgGrpDTO grpDto = (PiPatSrvPkgGrpDTO)pkgDto.getGroup().get(i);
			this.saveGrp(grpDto, newPkgDo.getId_patsrvpkg());
			
			newGrpList.add(grpDto);
		}
		
		//替换旧数据
		pkgDto.setPiPatSrvPkgDO(newPkgDo);
		pkgDto.setGroup(newGrpList);
	}
	
	/**
	 * 保存分组
	 * @param grpDto
	 * @param pkgId
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void saveGrp(PiPatSrvPkgGrpDTO grpDto,String pkgId) throws BizException {
		
		PipatsrvpkggrCrudServiceImpl grpService = new PipatsrvpkggrCrudServiceImpl();
		PipatsrvpkgitemCrudServiceImpl itemService = new PipatsrvpkgitemCrudServiceImpl();
		
		PiPatSrvPkggrDO grpDo = grpDto.getPiPatSrvPkggrDO();
		grpDo.setId_patsrvpkg(pkgId);
		
		List<PipatsrvpkgitemAggDO> list = new ArrayList<PipatsrvpkgitemAggDO>();
		PiPatSrvPkggrDO newGrpDo = grpService.insert(new PiPatSrvPkggrDO[]{grpDo})[0];
		for (int i = 0; i < grpDto.getItem().size(); i++) {
			PipatsrvpkgitemAggDO item = (PipatsrvpkgitemAggDO)grpDto.getItem().get(i);
			item.getParentDO().setId_patsrvpkg(newGrpDo.getId_patsrvpkg());
			item.getParentDO().setId_patsrvpkggr(newGrpDo.getId_patsrvpkggr());
			list.add(item);
		}
		
		PipatsrvpkgitemAggDO[] newItems = itemService.insert(list.toArray(new PipatsrvpkgitemAggDO[list.size()]));
	
		//替换旧数据
		if(!ArrayUtil.isEmpty(newItems)){
			grpDto.getItem().clear();
			for (PipatsrvpkgitemAggDO item : newItems) {
				grpDto.getItem().add(item);
			}
		}
		
		grpDto.setPiPatSrvPkggrDO(newGrpDo);
	}
}
