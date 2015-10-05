// Generated code from Butter Knife. Do not modify!
package arthur.mobileapps.com.vendingmachine.ui.views;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class VendingActivity$$ViewBinder<T extends arthur.mobileapps.com.vendingmachine.ui.views.VendingActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492951, "field 'balanceSummaryTV'");
    target.balanceSummaryTV = finder.castView(view, 2131492951, "field 'balanceSummaryTV'");
    view = finder.findRequiredView(source, 2131492948, "field 'configureTV' and method 'clickStock'");
    target.configureTV = finder.castView(view, 2131492948, "field 'configureTV'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickStock();
        }
      });
    view = finder.findRequiredView(source, 2131492950, "field 'vendingSummaryTV'");
    target.vendingSummaryTV = finder.castView(view, 2131492950, "field 'vendingSummaryTV'");
    view = finder.findRequiredView(source, 2131492952, "field 'productsGrid'");
    target.productsGrid = finder.castView(view, 2131492952, "field 'productsGrid'");
    view = finder.findRequiredView(source, 2131492949, "method 'clickStock'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.clickStock();
        }
      });
  }

  @Override public void unbind(T target) {
    target.balanceSummaryTV = null;
    target.configureTV = null;
    target.vendingSummaryTV = null;
    target.productsGrid = null;
  }
}
