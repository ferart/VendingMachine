// Generated code from Butter Knife. Do not modify!
package arthur.mobileapps.com.vendingmachine.ui.views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SellProductDialog$$ViewBinder<T extends arthur.mobileapps.com.vendingmachine.ui.views.SellProductDialog> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492956, "field 'newBalanceTV'");
    target.newBalanceTV = finder.castView(view, 2131492956, "field 'newBalanceTV'");
    view = finder.findRequiredView(source, 2131492958, "field 'returnChange'");
    target.returnChange = finder.castView(view, 2131492958, "field 'returnChange'");
    view = finder.findRequiredView(source, 2131492955, "field 'newBalanceLabel'");
    target.newBalanceLabel = finder.castView(view, 2131492955, "field 'newBalanceLabel'");
    view = finder.findRequiredView(source, 2131492957, "field 'changeLabel'");
    target.changeLabel = finder.castView(view, 2131492957, "field 'changeLabel'");
    view = finder.findRequiredView(source, 2131492959, "method 'onClickOk'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickOk();
        }
      });
  }

  @Override public void unbind(T target) {
    target.newBalanceTV = null;
    target.returnChange = null;
    target.newBalanceLabel = null;
    target.changeLabel = null;
  }
}
