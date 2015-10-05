package arthur.mobileapps.com.vendingmachine.ui.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import arthur.mobileapps.com.vendingmachine.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Arthur Rocha on 01/10/2015.
 * Fragment dialog that displays the new balance and the change to be given
 * if a purchased has been made, otherwise displays an error message
 */
public class SellProductDialog extends DialogFragment {

    private static SellProductDialog sellProductDialog;

    private float balance;
    private boolean selling;
    private String changeStr;

    //use of butterknife
    @Bind(R.id.new_balance_tv)
    TextView newBalanceTV;
    @Bind(R.id.return_money_tv)
    TextView returnChange;

    @Bind(R.id.new_balance_label)
    TextView newBalanceLabel;
    @Bind(R.id.return_money_label)
    TextView changeLabel;


    public SellProductDialog() {
    }

    /**
     * a new instance is created and some params are send into the bundle
     * @param context
     * @param balance
     * @param changeStr
     * @param selling
     * @return
     */
    public static SellProductDialog newInstance(Context context,float balance,String changeStr,boolean selling){
        SellProductDialog sellProductDialog=new SellProductDialog();
        Bundle bundle= new Bundle();
        bundle.putFloat("balance", balance);
        bundle.putString("changeStr",changeStr);
        bundle.putBoolean("selling",selling);
        sellProductDialog.setArguments(bundle);

        return  sellProductDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //the arguments are retrieved
        balance=getArguments().getFloat("balance");
        changeStr=getArguments().getString("changeStr");
        selling=getArguments().getBoolean("selling");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        dialog.setContentView(R.layout.new_order_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ButterKnife.bind(this,dialog); //applying butterknife functionality to the fragment view


        if (selling) { //if a pruchased was done
            newBalanceTV.setText("$" + String.valueOf(balance));
            returnChange.setText(changeStr);

        }else{ //error message, purchased was not done
            newBalanceLabel.setVisibility(View.GONE);
            changeLabel.setVisibility(View.GONE);
            newBalanceTV.setText(getString(R.string.error_selling));
        }





        return dialog;

    }


    /**
     * ok button
     */
    @OnClick(R.id.button_new_order_ok)
    public void onClickOk() {
        dismiss(); //close de dialog fragment
    }



}
