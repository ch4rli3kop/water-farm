package com.example.water_farm;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.water_farm.R.id;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 6, 0},
        k = 1,
        xi = 2,
        d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"},
        d2 = {"Lcom/example/prgroess/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "de_progr", "", "fe_progr", "hu_progr", "wa_progr", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateProgressBar", "app_debug"}
)
public final class DeviceViewActivity extends AppCompatActivity {
    private int de_progr;
    private int hu_progr;
    private int fe_progr;
    private int wa_progr;
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.updateProgressBar();
        ((Button)this._$_findCachedViewById(id.de_button_incr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.de_progr <= 90) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.de_progr = var10000.de_progr + 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.hu_button_incr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.hu_progr <= 90) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.hu_progr = var10000.hu_progr + 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.fe_button_incr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.fe_progr <= 90) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.fe_progr = var10000.fe_progr + 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.wa_button_incr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.wa_progr <= 90) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.wa_progr = var10000.wa_progr + 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.de_button_decr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.de_progr >= 10) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.de_progr = var10000.de_progr - 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.hu_button_decr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.hu_progr >= 10) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.hu_progr = var10000.hu_progr + 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.fe_button_decr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.fe_progr >= 10) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.fe_progr = var10000.fe_progr - 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
        ((Button)this._$_findCachedViewById(id.wa_button_decr)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View it) {
                if (DeviceViewActivity.this.wa_progr >= 10) {
                    DeviceViewActivity var10000 = DeviceViewActivity.this;
                    var10000.wa_progr = var10000.wa_progr - 10;
                    DeviceViewActivity.this.updateProgressBar();
                }

            }
        }));
    }

    private final void updateProgressBar() {
        ProgressBar var10000 = (ProgressBar)this._$_findCachedViewById(id.de_progress_bar);
        Intrinsics.checkNotNullExpressionValue(var10000, "de_progress_bar");
        var10000.setProgress(this.de_progr);
        TextView var1 = (TextView)this._$_findCachedViewById(id.de_text_view_progress);
        Intrinsics.checkNotNullExpressionValue(var1, "de_text_view_progress");
        var1.setText((CharSequence)("" + this.de_progr + '%'));
        var10000 = (ProgressBar)this._$_findCachedViewById(id.hu_progress_bar);
        Intrinsics.checkNotNullExpressionValue(var10000, "hu_progress_bar");
        var10000.setProgress(this.hu_progr);
        var1 = (TextView)this._$_findCachedViewById(id.hu_text_view_progress);
        Intrinsics.checkNotNullExpressionValue(var1, "hu_text_view_progress");
        var1.setText((CharSequence)("" + this.hu_progr + '%'));
        var10000 = (ProgressBar)this._$_findCachedViewById(id.fe_progress_bar);
        Intrinsics.checkNotNullExpressionValue(var10000, "fe_progress_bar");
        var10000.setProgress(this.fe_progr);
        var1 = (TextView)this._$_findCachedViewById(id.fe_text_view_progress);
        Intrinsics.checkNotNullExpressionValue(var1, "fe_text_view_progress");
        var1.setText((CharSequence)("" + this.fe_progr + '%'));
        var10000 = (ProgressBar)this._$_findCachedViewById(id.wa_progress_bar);
        Intrinsics.checkNotNullExpressionValue(var10000, "wa_progress_bar");
        var10000.setProgress(this.wa_progr);
        var1 = (TextView)this._$_findCachedViewById(id.wa_text_view_progress);
        Intrinsics.checkNotNullExpressionValue(var1, "wa_text_view_progress");
        var1.setText((CharSequence)("" + this.wa_progr + '%'));
    }

    public View _$_findCachedViewById(int var1) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }

        View var2 = (View)this._$_findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this._$_findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }

    }
}
