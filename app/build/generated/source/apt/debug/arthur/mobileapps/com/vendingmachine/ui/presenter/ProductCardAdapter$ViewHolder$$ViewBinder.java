// Generated code from Butter Knife. Do not modify!
package arthur.mobileapps.com.vendingmachine.ui.presenter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ProductCardAdapter$ViewHolder$$ViewBinder<T extends arthur.mobileapps.com.vendingmachine.ui.presenter.ProductCardAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492979, "field 'productPrice'");
    target.productPrice = finder.castView(view, 2131492979, "field 'productPrice'");
    view = finder.findRequiredView(source, 2131492978, "field 'productStock'");
    target.productStock = finder.castView(view, 2131492978, "field 'productStock'");
    view = finder.findRequiredView(source, 2131492976, "field 'status'");
    target.status = finder.castView(view, 2131492976, "field 'status'");
    view = finder.findRequiredView(source, 2131492977, "field 'circleImage'");
    target.circleImage = finder.castView(view, 2131492977, "field 'circleImage'");
  }

  @Override public void unbind(T target) {
    target.productPrice = null;
    target.productStock = null;
    target.status = null;
    target.circleImage = null;
  }
}
