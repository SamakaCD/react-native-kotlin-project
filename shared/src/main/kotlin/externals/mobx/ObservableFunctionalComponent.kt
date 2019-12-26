package com.reactnativekotlinproject.externals.mobx

import com.ivansadovyi.mobx.reaction
import react.*

fun <P : RProps> observableFunctionalComponent(
        func: RBuilder.(props: P) -> Unit
): FunctionalComponent<P> {
    return { props: P ->
        buildElements {
            val (updateId, setUpdateId) = useState(0)
            var isRendered = false
            val disposable = reaction(
                    data = {
                        if (!isRendered) {
                            func(props)
                            isRendered = true
                        }
                    },
                    sideEffect = {
                        setUpdateId(updateId + 1)
                    }
            )

            useEffectWithCleanup(effect = {
                {
                    disposable.dispose()
                }
            })
        }
    }
}