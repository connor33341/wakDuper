package me.jndildap.mixin.screen;

import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.apache.commons.lang3.ArrayUtils;
import me.jndildap.WakDuper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = VideoOptionsScreen.class, priority = 1337)
public abstract class VideoOptionsScreenMixin {

    @Inject(at = @At("RETURN"), method = "getOptions", cancellable = true)
    private static void getOptions(GameOptions gameOptions, CallbackInfoReturnable<SimpleOption<?>[]> cir) {
        SimpleOption<?>[] values = cir.getReturnValue();
        values = ArrayUtils.insert(9, values, WakDuper.format);
        values = ArrayUtils.insert(10, values, WakDuper.overlay);
        cir.setReturnValue(ArrayUtils.insert(11, values, WakDuper.copyJson));
    }

}