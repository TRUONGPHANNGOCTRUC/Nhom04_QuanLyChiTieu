// Generated by view binder compiler. Do not edit!
package com.example.asstkgd.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

public final class DiolagUpdateLoaiThuBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton btnAdd;

  @NonNull
  public final AppCompatButton btnExit;

  @NonNull
  public final TextInputEditText edName;

  private DiolagUpdateLoaiThuBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatButton btnAdd, @NonNull AppCompatButton btnExit,
      @NonNull TextInputEditText edName) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.btnExit = btnExit;
    this.edName = edName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DiolagUpdateLoaiThuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DiolagUpdateLoaiThuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.diolag_update_loai_thu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DiolagUpdateLoaiThuBinding bind(@NonNull View rootView) {
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

      id = R.id.ed_name;
      TextInputEditText edName = ViewBindings.findChildViewById(rootView, id);
      if (edName == null) {
        break missingId;
      }

      return new DiolagUpdateLoaiThuBinding((LinearLayout) rootView, btnAdd, btnExit, edName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
