package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("rawtypes")
public class PageResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long total;// 总记录数
	private List Rows;// 当前页记录

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return Rows;
	}

	public void setRows( List rows) {
		Rows = rows;
	}

	public PageResult(long total, List rows) {
		super();
		this.total = total;
		Rows = rows;
	}
	
	
}
