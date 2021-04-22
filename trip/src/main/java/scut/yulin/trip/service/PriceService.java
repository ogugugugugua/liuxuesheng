package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.price.InsertPriceDTO;
import scut.yulin.trip.dto.price.ModifyPriceDTO;
import scut.yulin.trip.dto.price.QueryPriceDTO;
import scut.yulin.trip.model.Price;

/**
 * @Date 2021/4/22
 * @Author xieyulin
 * @Description TODO
 **/
public interface PriceService {

  public Price getPriceByUUID(QueryPriceDTO queryPriceDTO);

  public List<Price> getPriceList(QueryPriceDTO queryPriceDTO);

  public int addNewPrice(InsertPriceDTO insertPriceDTO);

  public int deletePrice(QueryPriceDTO queryPriceDTO);

  public int modifyPrice(ModifyPriceDTO modifyPriceDTO);

}
