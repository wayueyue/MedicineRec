package io.github.talelin.latticy.web.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Zhang Xilong 81840
 * @date 2021/3/5
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T> {

	private int pageNum;
	private int pageSize;
	private int totalCount;
	private List<T> data;

}
