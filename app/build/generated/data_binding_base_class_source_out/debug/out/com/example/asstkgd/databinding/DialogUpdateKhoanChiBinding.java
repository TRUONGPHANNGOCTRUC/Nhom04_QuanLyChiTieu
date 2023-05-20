// Generated by view binder compiler. Do not edit!
package com.example.asstkgd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.asstkgd.R;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class DialogUpdateKhoanChiBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton btnAdd;

  @NonNull
  public final AppCompatButton btnExit;

  @NonNull
  public final ImageView datePicker;

  @NonNull
  public final TextInputEditText edHmName;

  @NonNull
  public final TextInputEditText edMoney;

  @NonNull
  public final TextInputEditText edName;

  @NonNull
  public final TextInputEditText edNote;

  @NonNull
  public final Spinner spLoai;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextInputEditText tvDate;

  private DialogUpdateKhoanChiBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatButton btnAdd, @NonNull AppCompatButton btnExit,
      @NonNull ImageView datePicker, @NonNull TextInputEditText edHmName,
      @NonNull TextInputEditText edMoney, @NonNull TextInputEditText edName,
      @NonNull TextInputEditText edNote, @NonNull Spinner spLoai, @NonNull TextView textView,
      @NonNull TextInputEditText tvDate) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.btnExit = btnExit;
    this.datePicker = datePicker;
    this.edHmName = edHmName;
    this.edMoney = edMoney;
    this.edName = edName;
    this.edNote = edNote;
    this.spLoai = spLoai;
    this.textView = textView;
    this.tvDate = tvDate;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DialogUpdateKhoanChiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DialogUpdateKhoanChiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.dialog_update_khoan_chi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DialogUpdateKhoanChiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_add;
      AppCompatButton btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.btn_exit;
      AppCompatButton btnExit = ViewBindings.findChildViewById(rootView, id);
      if (btnExit == null) {
        break missingId;
      }

      id = R.id.datePicker;
      ImageView datePicker = ViewBindings.findChildViewById(rootView, id);
      if (datePicker == null) {
        break missingId;
      }

      id = R.id.ed_hm_name;
      TextInputEditText edHmName = ViewBindings.findChildViewById(rootView, id);
      if (edHmName == null) {
        break missingId;
      }

      id = R.id.ed_money;
      TextInputEditText edMoney = ViewBindings.findChildViewById(rootView, id);
      if (edMoney == null) {
        break missingId;
      }

      id = R.id.ed_name;
      TextInputEditText edName = ViewBindings.findChildViewById(rootView, id);
      if (edName == null) {
        break missingId;
      }

      id = R.id.ed_note;
      TextInputEditText edNote = ViewBindings.findChildViewById(rootView, id);
      if (edNote == null) {
        break missingId;
      }

      id = R.id.sp_loai;
      Spinner spLoai = ViewBindings.findChildViewById(rootView, id);
      if (spLoai == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.tv_date;
      TextInputEditText tvDate = ViewBindings.findChildViewById(rootView, id);
      if (tvDate == null) {
        break missingId;
      }

      return new DialogUpdateKhoanChiBinding((LinearLayout) rootView, btnAdd, btnExit, datePicker,
          edHmName, edMoney, edName, edNote, spLoai, textView, tvDate);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
