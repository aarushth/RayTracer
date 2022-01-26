public class Shape {
	protected Color color;
	protected float kD;
	protected float kA;
	protected float reflectivity;
	protected int id;
	protected static int ID_COUNT = 0;
	
	public int getID() {
		return id;
	}

	public IntersectionDetails intersection(Vector ray, Point origin) {
		return null;
	}
	public Vector getNormal(IntersectionDetails intersection) {
		return null;
	}
	
	public Color colorCalc(IntersectionDetails intersection, Vector view, Point lightSource, Color lightColor, boolean isLightReaching, Scene scene, int recursionDepth) {
		Color finalCol = null;
		Color ambientCol = intersection.getColor().multiply(kA).multiply(lightColor);
		Vector normal = getNormal(intersection);
		float normalCheck1 = normal.dotProduct(Vector.getUnitVector(view.multiply(-1f)));
		float normalCheck2 = normal.multiply(-1f).dotProduct(Vector.getUnitVector(view.multiply(-1f)));
		if(normalCheck2 > normalCheck1) {
			normal = normal.multiply(-1f);
		}
		Vector light = Vector.getUnitVector(new Vector(lightSource, intersection.getPoint()));
		float dp = Math.max(light.dotProduct(normal), 0);
		if(isLightReaching) {
				Color diffuseCol = intersection.getColor().multiply(lightColor.multiply(kD*dp));
				finalCol = ambientCol.add(diffuseCol);
		}else {
			finalCol = ambientCol;
		}
		view = view.multiply(-1f);
		float NdpV = normal.dotProduct(view);
		if(reflectivity > 0) {
			Vector reflection = Vector.getUnitVector(normal.multiply(NdpV*2f).subtract(view));
			finalCol = finalCol.add(scene.traceRay(reflection, intersection.getPoint(), recursionDepth).multiply(reflectivity));
		}
		return finalCol;
	}


}
