/*
* Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
*
* Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:
*
*    1. Redistributions of source code must retain the above copyright notice, this list of
*       conditions and the following disclaimer.
*
*    2. Redistributions in binary form must reproduce the above copyright notice, this list
*       of conditions and the following disclaimer in the documentation and/or other materials
*       provided with the distribution.
*
* THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
* WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
* FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
* CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
* CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
* SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
* ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
* NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
* ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* The views and conclusions contained in the software and documentation are those of the
* authors and should not be interpreted as representing official policies, either expressed
* or implied, of BetaSteward_at_googlemail.com.
*/

package mage.abilities.effects;

import java.util.UUID;
import mage.Constants.EffectType;
import mage.Constants.Outcome;
import mage.abilities.Ability;
import mage.abilities.Mode;
import mage.target.targetpointer.FirstTargetPointer;
import mage.target.targetpointer.TargetPointer;

/**
 *
 * @author BetaSteward_at_googlemail.com
 */
public abstract class EffectImpl<T extends Effect<T>> implements Effect<T> {

	protected UUID id;
	protected final Outcome outcome;
	protected EffectType effectType;
    protected TargetPointer targetPointer = FirstTargetPointer.getInstance();
    protected String staticText = "";

	public EffectImpl(Outcome outcome) {
		this.id = UUID.randomUUID();
		this.outcome = outcome;
	}

	public EffectImpl(final EffectImpl effect) {
		this.id = effect.id;
		this.outcome = effect.outcome;
		this.effectType = effect.effectType;
        this.staticText = effect.staticText;
        this.targetPointer = effect.targetPointer.copy();
	}

	@Override
	public UUID getId() {
		return id;
	}

	@Override
	public String getText(Mode mode) {
		return staticText;
//        if (staticText.equals("")) {
//            return getDynamicText(source);
//        } else {
//            return staticText;
//        }
	}

//    protected String getDynamicText(Ability source) {
//        return "";
//    }

//    public void setStaticText(String staticText) {
//        this.staticText = staticText;
//    }

	@Override
	public Outcome getOutcome() {
		return outcome;
	}

	@Override
	public EffectType getEffectType() {
		return effectType;
	}

    @Override
    public void setTargetPointer(TargetPointer targetPointer) {
        this.targetPointer = targetPointer;
    }

	@Override
	public TargetPointer getTargetPointer() {
		return this.targetPointer;
	}
}
