package cp.addressselector;

import cp.addressselector.model.City;
import cp.addressselector.model.County;
import cp.addressselector.model.Province;
import cp.addressselector.model.Street;

public interface OnAddressSelectedListener {
    void onAddressSelected(Province province, City city, County county, Street street);
}
