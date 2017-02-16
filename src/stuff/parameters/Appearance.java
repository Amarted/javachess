/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stuff.parameters;

/**
 *
 * @author massakra
 */
public class Appearance {
	private String model;
	/** Set model */
	public void model(String model) {
		this.model = model;
	}
	/** Render model */
	public void render() {
		System.out.print(this.model);
	}
}
