package trueprotocol.bundlefixprogressivearchery.mixin;
import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class DisableProgressiveArcheryMixins implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        return mixinClassName.equals("solipingen.progressivearchery.mixin.component.BundleContentsComponent$BuilderMixin") ||
                mixinClassName.equals("solipingen.progressivearchery.mixin.component.BundleContentsComponentMixin") ||
                mixinClassName.equals("solipingen.progressivearchery.mixin.item.BundleItemMixin");
    }
}
