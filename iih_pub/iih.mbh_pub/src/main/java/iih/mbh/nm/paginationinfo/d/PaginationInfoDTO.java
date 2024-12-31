package iih.mbh.nm.paginationinfo.d;

public class PaginationInfoDTO {

	// 是否返回总记录数
	private boolean isrdcountreturned;
	// 总页数
	private int pagecount;
	// 页索引
	private int pageindex;
	// 页大小
	private int pagesize;
	// 总记录数
	private int recordscount;

	public boolean getIsrdcountreturned() {
		return isrdcountreturned;
	}

	public void setIsrdcountreturned(boolean isrdcountreturned) {
		this.isrdcountreturned = isrdcountreturned;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getPageindex() {
		return pageindex;
	}

	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getRecordscount() {
		return recordscount;
	}

	public void setRecordscount(int recordscount) {
		this.recordscount = recordscount;
	}

}
